package proxy.copyproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MClassLoader extends ClassLoader {

    private File classPathFile;

    public MClassLoader() {
        String classPath = MClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
       String className =  MClassLoader.class.getPackage().getName()+"."+name;
       if(classPathFile !=null){
           File classFIle = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
           if(classFIle.exists()){
               FileInputStream in = null;
               ByteArrayOutputStream out = null;
               try {
                    in  = new FileInputStream(classFIle);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
               }catch (Exception e){
                    e.printStackTrace();
               }
           }
       }
       return null;
    }


}
