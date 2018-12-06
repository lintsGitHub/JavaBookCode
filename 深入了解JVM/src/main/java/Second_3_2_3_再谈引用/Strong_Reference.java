package Second_3_2_3_再谈引用;



public class Strong_Reference {
    public static Strong_Reference strong_reference = null ;

    public void isAlive(){
        System.out.println("Yes,I am still alive. ");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
        Strong_Reference.strong_reference = this;
    }

    public static void main(String[] args) throws Throwable {
        strong_reference = new Strong_Reference();
        strong_reference = null ;
        System.gc();
        Thread.sleep(5000);
        if (strong_reference != null){
            strong_reference.isAlive();
        }else {
            System.out.println("对象不存在");
        }
        strong_reference = null ;
        System.gc();
        Thread.sleep(5000);
        if (strong_reference != null){
            strong_reference.isAlive();
        }else {
            System.out.println("对象不存在");
        }
    }
}
