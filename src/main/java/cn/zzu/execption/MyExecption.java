package cn.zzu.execption;

/**
 * 我的异常类
 *
 * @author silence
 * @create 2019-04-06-18:14
 */
public class MyExecption extends Exception {

    private static final long serialVersionUID = 1L;

    public MyExecption(){

    }

    public MyExecption(String msg){
        super(msg);
    }

}
