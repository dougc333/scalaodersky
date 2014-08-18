import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs;
import org.apache.hadoop.fs.Path;


class TestHDFSJava{


  public static void main(String []args) throws Exception{
    try{
       Configuration conf = new Configuration();
       conf.addResource("/usr/lib/hadoop/etc/hadoop/core-site.xml");
       conf.addResource("/usr/lib/hadoop/etc/hadoop/hdfs-site.xml");
       Path path = new Path("hdfs://user/dc/testfile.txt");       
       FileSystem fs = path.getFileSystem(conf);
       System.out.println("fs uri:"+fs.getUri());
       System.out.println("fs.workingDirectory:"+fs.getWorkingDirctory());
    }catch(Exception e){
      e.printStackTrace();
    }

  }


}
