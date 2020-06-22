package com.jang.libjava;

public class ObjParamTest {
    ObjParam obj;

    void setObj(ObjParam new_obj) {
        obj = new_obj;
        obj.print();
    }
    ObjParam getObj() {
        obj.str = "return ObjParam";
        return obj;
    }
}
