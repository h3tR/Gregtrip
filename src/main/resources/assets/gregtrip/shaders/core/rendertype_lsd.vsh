#version 150

#moj_import <light.glsl>
#moj_import <fog.glsl>
#moj_import <gregtrip:color.glsl>

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
uniform int Time;
uniform float WaveStrength;
uniform float PlayerSpeed;


out float vertexDistance;
out vec4 vertexColor;
out vec2 texCoord0;
out vec4 normal;


void main() {
    vec3 pos = Position + ChunkOffset;

    vertexDistance = fog_distance(ModelViewMat, pos, FogShape);
    if(PlayerSpeed<.1f){
        float waveModifier =  1024/WaveStrength*pow(vertexDistance, 1/20f);
        pos.x += sin(pos.z*pos.x*pos.y*.5+Time/8F)/waveModifier;
        pos.y += cos(pos.z*-pos.x*pos.y*.5+Time/8F)/waveModifier;
        pos.z -= cos(-pos.z*-pos.x*pos.y*.5+Time/8F)/waveModifier;
    }

    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);
   /* vec4 vibrantColor = RGBAtoHSVA(Color);
    vibrantColor.y=.8f;*/

    vertexColor = Color * minecraft_sample_lightmap(Sampler2, UV2);

    texCoord0 = UV0;

    normal = ProjMat * ModelViewMat * vec4(Normal, 0.0);
}
