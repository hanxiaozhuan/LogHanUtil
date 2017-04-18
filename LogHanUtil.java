import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHanUtil {
	
	public static String windowPath = null;
	
	public static String linuxPath = null;
	
	
	public static void writeLog(Object obj)
    {
        try
        {
        	String path=choosePath();
	        File file=new File(path);
	        if(!file.exists())
	            file.createNewFile();
	        FileOutputStream out=new FileOutputStream(file,true); //如果追加方式用true        
	        StringBuffer sb=new StringBuffer();
	        sb.append(obj.toString()+"\n");
	        out.write(sb.toString().getBytes("utf-8"));//注意需要转换对应的字符集
	        out.close();
	        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }    
    @SuppressWarnings("resource")
	public static String readLog()
    {
    	StringBuffer sb=new StringBuffer();
        String tempstr=null;
        try{
        	String path=choosePath();
            File file=new File(path);
            if(!file.exists())
                throw new FileNotFoundException();            
            FileInputStream fis=new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            while((tempstr=br.readLine())!=null)
                sb.append(tempstr);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
        return sb.toString();
    }
    
    public static String choosePath(){
    	String path;
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	String day = sdf.format(new Date());
    	String os = System.getProperty("os.name");  
    	if(os.toLowerCase().startsWith("win")){
    		if(windowPath!=null){
    			path = windowPath;
    		}else{
    			path=day+".log";
    		}
    	}else{
    		if(linuxPath!=null){
    			path = linuxPath;
    		}else{
    			path="/root/log/"+day+".log";
    		}
    	}
    	return path;
    }
    
    public static void main(String[] args) {
    	test t = new test("2017-4-5","test","han","测试");
        writeLog(t);
       
    }
    
	
    public static String getWindowPath() {
		return windowPath;
	}
	public static void setWindowPath(String windowPath) {
		LogHanUtil.windowPath = windowPath;
	}
	public static String getLinuxPath() {
		return linuxPath;
	}
	public static void setLinuxPath(String linuxPath) {
		LogHanUtil.linuxPath = linuxPath;
	}
}
