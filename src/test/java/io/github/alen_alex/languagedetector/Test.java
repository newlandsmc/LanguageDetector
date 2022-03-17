package io.github.alen_alex.languagedetector;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import com.detectlanguage.responses.StatusResponse;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static final String API_KEY = "57824c8884271b0f4fbfb0c48003e4f4";
    private static final List<String> TEST_CASES;

    static {
        TEST_CASES = new ArrayList<String>(){{
            add("Bugün bulusmami lazimdiii");
            add("Volkan konak adami tribe sokar yemin ederim :D");
            add("I felt my first flash of violence at some fool who bumped into me.... I pity the fool.");
            add("@BeGinkiTh otak ang semangat nak blajaq !");
            add("@Dennycrowe all over twitter because you and your friends cant stick up for yourselves.");
            add("The way you treat me. The way you accept me, and love me. How much you care about me. That's what ma...");
            add("Oh there's that fake door slam noise , ugh #CBB");
            add("vou começar pela melhor metade (8)");
            add("Jajajaja bolitaaaaaa!!!!\\\" siiii!!!\"");
            add("Regalame el reloj mejor xDDDDDDDDDD");
            add("Müdürlüğümüzün 2013 yılında hayata geçireceği projeler üzerinde ki çalışmalar sona yaklaşıldı.");
            add("Volkan konak adami tribe sokar yemin ederim password");
            add("pwd, bccl, kinlay, lotay, dopshari, gaupay, dargay, helvetas, cdb, pangray, bijay, chojay, sanjay, td, yargay, dcd, gortab, helvatas, jurmay, kaflay, namsay, bg, chungdruk, draftman, gynecologist, mangjay, minjay, nakphay, norbooz, surjay, agrewal, allaway, apecs, bagdogra, bajay, bokray, bumdrag, changchay, chejay, chenray, chotay, dd, dhopshari, dtl, echay, emssd, fd, fsd, gajay, ganglue, gaygay, gaypay, gopay, gunjay, halvetas, hideway, hoilday, hungrap, iffch, jamgay, js, jungnay, karpay, kharl, lakshay, lingshay, lunjay, mafchan, malabasay, mso, nangsay, naphay, ninjay, pelgay, phojay, ramashray, ratney, ropeway, sarswati, sujay, sumjay, swapan, tenshay, thajay, thenpay, thsewang, tlt, tobjay, trk, tshejay, wanjay, yongdrag, aircraf, lubzor");
            add("Crea una password");
        }};
    }

    public Test(){
        DetectLanguage.apiKey = API_KEY;
        DetectLanguage.ssl = true;

    }

    public void doTest(){
        try {
            StatusResponse statusResponse = DetectLanguage.getStatus();

            System.out.println(statusResponse.getStatus());
            System.out.println(statusResponse.getPlan());
            System.out.println(statusResponse.getRequests());
            System.out.println(statusResponse.getPlanExpires());
        } catch (APIError e) {
            e.printStackTrace();
        }
    }





}
