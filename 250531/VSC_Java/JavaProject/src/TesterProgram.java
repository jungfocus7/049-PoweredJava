
// import java.text.Format;
import java.text.MessageFormat;

public final class TesterProgram {
    private static void println(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // String txt = null;
        // println("Hello, World!" + txt.toString());

        // long lms = System.currentTimeMillis();

        // int cnt = 0;
        // for (int i = 0; i < 100000000; i++) {
        // String txt = MessageFormat.format("개발자 {0}", "박종명");
        // // println(txt);
        // cnt += txt.length();
        // }

        // lms = System.currentTimeMillis() - lms;
        // println(">>> " + cnt);
        // println(">>> " + lms);

        // Thread.sleep(50000);

        StringBuilder tsb = new StringBuilder();
        for (int l = 10000, i = 0; i < l; i++) {
            int h = i % 3;
            if (h == 0) {
                tsb.append('박');
            } else if (h == 1) {
                tsb.append('종');
            } else if (h == 2) {
                tsb.append('명');
            }
        }

        println(tsb.toString());


        // String tnm = "박종명";
        // char[] tca = tnm.toCharArray();
        // for (char tc : tca) {
        //     println(": " + tc);
        // }
    }
}
