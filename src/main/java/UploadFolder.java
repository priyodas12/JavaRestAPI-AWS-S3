import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;

import java.io.File;

public class UploadFolder {
    public static void main(String[] args) throws AmazonClientException, AmazonServiceException {
        TransferManager transferManager=new TransferManager();
        final String dirPath="C:\\Users\\Priyo\\Desktop\\Docker";
        final String keyPrefix="java-s3-25082020";
        final String bucketName="java-s3-24082020";

        MultipleFileUpload multipleFileUpload=transferManager.uploadDirectory(bucketName,keyPrefix,new File(dirPath), false);

        try{
            multipleFileUpload.waitForCompletion();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        transferManager.shutdownNow();
    }
}
