#version 150

vec4 RGBAtoHSVA(vec4 rgb){
    float r = rgb.x;
    float g = rgb.y;
    float b = rgb.z;
    float minv = min(min(r,g),b);
    float maxv = max(max(r,g),b);


    float v = maxv;
    float delta = maxv - minv;
    float s;
    float h;
    s = delta / maxv;


    if( r == maxv ){
        h = ( g - b ) / delta;      // between yellow & magenta

    } else if( g == maxv ){
        h = 2 + ( b - r ) / delta;  // between cyan & yellow

    } else {
        h = 4 + ( r - g ) / delta;  // between magenta & cyan

    }
    h *= 60;                // degrees
    if( h < 0 ){
        h += 360;
    }
    return vec4(h,s,v,rgb.w);
}
vec4 HSVAtoRGBA(vec4 hsv){
    float h = hsv.x;
    float s = hsv.y;
    float v = hsv.z;

    if(s == 0 ) {
        return vec4(v,v,v,hsv.w);
    }

    h /= 60;            // sector 0 to 5
    float i = floor(h);
    int f = int(h - i);          // factorial part of h
    float p = v * ( 1 - s );
    float q = v * ( 1 - s * f );
    float t = v * ( 1 - s * ( 1 - f ) );


    float r;
    float g;
    float b;
    if(i==0){
        r = v;
        g = t;
        b = p;
    } else if(i==1){
        r = q;
        g = v;
        b = p;
    } else if(i==2){
        r = p;
        g = v;
        b = t;
    } else if(i==3){
        r = p;
        g = q;
        b = v;
    } else if(i==4){
        r = t;
        g = p;
        b = v;
    } else {
        r = v;
        g = p;
        b = q;
    }

    return vec4(r,g,b,hsv.w);
}