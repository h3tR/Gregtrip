#version 330 core

#moj_import <light.glsl>
#moj_import <fog.glsl>
#moj_import <gregtrip:lsd_effects.glsl>

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV2;
in vec3 Normal;

uniform sampler2D Sampler2;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform vec3 ChunkOffset;
uniform int FogShape;
uniform float Time;
uniform float WaveStrength;
uniform float PlayerSpeedModifier;


out float vertexDistance;
out vec4 vertexColor;
out vec2 texCoord0;
out vec4 normal;


void main() {
    vec3 pos = Position + ChunkOffset;

    vertexDistance = fog_distance(ModelViewMat, pos, FogShape);



    gl_Position = ProjMat * ModelViewMat * vec4(pos+getLSDVertexOffset(pos, vertexDistance, PlayerSpeedModifier, Time, WaveStrength), 1.0);
    /* vec4 vibrantColor = RGBAtoHSVA(Color);
     vibrantColor.y=.8f;*/

    vertexColor = Color * minecraft_sample_lightmap(Sampler2, UV2);

    texCoord0 = UV0;

    normal = ProjMat * ModelViewMat * vec4(Normal, 0.0);
}