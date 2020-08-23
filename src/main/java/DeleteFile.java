import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class DeleteFile {
    public static void main(String[] args) {
        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        final String bucketName="java-s3-24082020";
        //String objectKey="java-s3-25082020/abc.txt";
        final String objectKey="SQS-Tutorial-20200823";

        try{
            s3.deleteObject(bucketName,objectKey);
        }catch (AmazonServiceException e){
            e.getErrorMessage();
        }
    }
}
