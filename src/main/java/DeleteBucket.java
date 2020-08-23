import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class DeleteBucket {
    public static void main(String[] args) {
        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        final String bucketName="java-s3-24082020";

        try{
            s3.deleteBucket(bucketName);
        }catch (AmazonServiceException e){
            e.getErrorMessage();
        }
    }
}
