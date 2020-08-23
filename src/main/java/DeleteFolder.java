import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class DeleteFolder {
    public static void main(String[] args) {
        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        final String bucketName="java-s3-24082020";
        final String objectKey="java-s3-25082020";

        ObjectListing objects=s3.listObjects(bucketName,objectKey);

        //before deleting objects we have to delete each object inside it
        for(S3ObjectSummary s3ObjectSummary:objects.getObjectSummaries()){
            try{
                s3.deleteObject(bucketName,s3ObjectSummary.getKey());
            }catch (AmazonServiceException e){
                e.getErrorMessage();
            }
        }
    }
}
