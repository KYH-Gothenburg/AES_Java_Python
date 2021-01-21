import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main {
   public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
   InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, IOException {
      AES aes = new AES();
      IvParameterSpec iv = aes.generateIV();
      aes.saveIv("myiv.iv", iv);
      SecretKeySpec skey = aes.keyFromPassPhrase("s3cr37passw0RD");
      aes.encrypt("Nu tar vi lunch lunch!", "crypto2.enc", skey, iv);

      String result = aes.decrypt("crypto2.enc", skey, iv);
      System.out.println(result);
   }
}