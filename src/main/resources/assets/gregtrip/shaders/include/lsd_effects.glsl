

vec3 getLSDVertexOffset(vec3 position, float vertexDistance, float PlayerSpeedModifier, float Time, float WaveStrength){
    float distanceModifier =  max(4,pow(vertexDistance,1.5f));

    vec3 posOffset = vec3(0);

    posOffset.x = sin(position.z*position.x*position.y*.5+Time/distanceModifier);
    posOffset.y = cos(position.z*-position.x*position.y*.5+Time/distanceModifier);
    posOffset.z = -cos(-position.z*-position.x*position.y*.5+Time/distanceModifier);

    posOffset /= 64/WaveStrength;
    posOffset *= pow(vertexDistance, 1/5f);
    posOffset *= pow(PlayerSpeedModifier,2f);
    return posOffset;
}

