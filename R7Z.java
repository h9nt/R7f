package X;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class R7Z implements C3515RcB {
    public final C0924PsU A00;

    public R7Z(byte[] bArr) {
        this.A00 = new C0924PsU(bArr);
    }

    public final byte[] AJ7(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length >= 40) {
            byte[] copyOf = Arrays.copyOf(bArr, 24);
            return this.A00.A02(ByteBuffer.wrap(bArr, 24, length - 24), copyOf, bArr2);
        }
        throw P73.A0l("ciphertext too short");
    }

    public final byte[] AMQ(byte[] bArr, byte[] bArr2) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 24 + 16);
        byte[] A002 = C1893Qab.A00(24);
        allocate.put(A002);
        this.A00.A01(allocate, A002, bArr, bArr2);
        return allocate.array();
    }
}
