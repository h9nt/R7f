package X;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class R7f implements C3515RcB {
    public static final ThreadLocal A01 = new RPQ();
    public final SecretKey A00;

    public R7f(byte[] bArr) {
        C2301QlB.A01(bArr.length);
        this.A00 = new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec A00(byte[] bArr, int i) {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i);
        } catch (ClassNotFoundException unused) {
            if ("The Android Project".equals(System.getProperty("java.vendor"))) {
                return new IvParameterSpec(bArr, 0, i);
            }
            throw P73.A0l("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }

    public final byte[] AJ7(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length >= 28) {
            AlgorithmParameterSpec A002 = A00(bArr, 12);
            ThreadLocal threadLocal = A01;
            ((Cipher) threadLocal.get()).init(2, this.A00, A002);
            P75.A1X(threadLocal, bArr2);
            return ((Cipher) threadLocal.get()).doFinal(bArr, 12, length - 12);
        }
        throw P73.A0l("ciphertext too short");
    }

    public final byte[] AMQ(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        int length = bArr.length;
        if (length <= 2147483619) {
            byte[] bArr4 = new byte[(length + 12 + 16)];
            byte[] A002 = C1893Qab.A00(12);
            System.arraycopy(A002, 0, bArr4, 0, 12);
            AlgorithmParameterSpec A003 = A00(A002, A002.length);
            ThreadLocal threadLocal = A01;
            ((Cipher) threadLocal.get()).init(1, this.A00, A003);
            P75.A1X(threadLocal, bArr2);
            int doFinal = ((Cipher) threadLocal.get()).doFinal(bArr3, 0, length, bArr4, 12);
            if (doFinal == length + 16) {
                return bArr4;
            }
            throw P74.A0Q("encryption failed; GCM tag must be %s bytes, but got only %s bytes", BvW.A1b(16, doFinal - length));
        }
        throw P73.A0l("plaintext too long");
    }
}
