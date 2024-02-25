package X;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class R7Y implements C3515RcB {
    public final C0923PsT A00;

    public R7Y(byte[] bArr) {
        this.A00 = new C0923PsT(bArr);
    }

    public final byte[] AJ7(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length >= 28) {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            return this.A00.A02(ByteBuffer.wrap(bArr, 12, length - 12), copyOf, bArr2);
        }
        throw P73.A0l("ciphertext too short");
    }

    public final byte[] AMQ(byte[] bArr, byte[] bArr2) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + 16);
        byte[] A002 = C1893Qab.A00(12);
        allocate.put(A002);
        this.A00.A01(allocate, A002, bArr, bArr2);
        return allocate.array();
    }
}
