#version 400

#import <sodium:include/fog.glsl>
#import <sodium:include/chunk_vertex.glsl>
#import <sodium:include/chunk_matrices.glsl>
#import <sodium:include/chunk_material.glsl>
#import <gregtrip:include/lsd_effects.glsl>

out vec3 v_ColorModulator;
out vec2 v_TexCoord;

out float v_MaterialMipBias;
out float v_MaterialAlphaCutoff;

#ifdef USE_FOG
out float v_FragDistance;
#endif

uniform int u_FogShape;
uniform vec3 u_RegionOffset;

uniform float u_Time;
uniform float u_WaveStrength;
uniform float u_PlayerSpeedModifier;

uniform sampler2D u_LightTex; // The light map texture sampler

#if defined(VERTEX_FORMAT_COMPACT)
// expect 0-15 as inputs, Sodium 0.5 logic
vec3 _sample_lightmap(uvec2 coord) {
    return texelFetch(u_LightTex, ivec2(coord), 0).rgb;
}
#elif defined(VERTEX_FORMAT_FULL)
// expect UV coords as inputs
vec3 _sample_lightmap(uvec2 uv) {
    return texture(u_LightTex, clamp((ivec2(uv) / 256.0), vec2(0.5 / 16.0), vec2(15.5 / 16.0))).rgb;
}
#else
#error Unexpected format
#endif

uvec3 _get_relative_chunk_coord(uint pos) {
    // Packing scheme is defined by LocalSectionIndex
    return uvec3(pos) >> uvec3(5u, 0u, 2u) & uvec3(7u, 3u, 7u);
}

vec3 _get_draw_translation(uint pos) {
    return _get_relative_chunk_coord(pos) * vec3(16.0);
}

void main() {
    _vert_init();

    // Transform the chunk-local vertex position into world model space
    vec3 translation = u_RegionOffset + _get_draw_translation(_vert_mesh_id);
    vec3 position = _vert_position + translation;

    v_FragDistance = getFragDistance(u_FogShape, position);

    // Transform the vertex position into model-view-projection space
    gl_Position = u_ProjectionMatrix * u_ModelViewMatrix * vec4(position+getLSDVertexOffset(position, v_FragDistance, u_PlayerSpeedModifier, u_Time, u_WaveStrength), 1.0);

    v_ColorModulator = _vert_color * _sample_lightmap(_vert_light);
    v_TexCoord = _vert_tex_coord;

    v_MaterialMipBias = _material_mip_bias(_vert_material);
    v_MaterialAlphaCutoff = _material_alpha_cutoff(_vert_material);
}