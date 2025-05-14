package BM23AI069;

public class wrapper {
    public static void main(String[] args){
        int primitiveInt = 10;
        Integer boxedInt = primitiveInt;
        float primitiveFloat = 5.9f;
        Float boxedFloat = primitiveFloat;
        boolean primitiveBoolean = true;
        Boolean boxedBoolean = primitiveBoolean;
        char primitiveChar = 'H';
        Character boxedChar = primitiveChar;

        int unboxedInt = boxedInt;
        float unboxedFloat = boxedFloat;
        boolean unboxedBoolean = boxedBoolean;
        char unboxedChar = boxedChar;
        System.out.println("boxing AND unboxing");
        System.out.println("boxed integer:" + boxedInt + "---> unboxed integer:" + unboxedInt);
        System.out.println("boxed Float:" + boxedFloat + "---> unboxed float:" + unboxedFloat);
        System.out.println("boxed boolean:" + boxedBoolean + "---> unboxed boolean:" + unboxedBoolean);
        System.out.println("boxed character:" + boxedChar + "---> unboxed character:" + unboxedChar);
    }
}
