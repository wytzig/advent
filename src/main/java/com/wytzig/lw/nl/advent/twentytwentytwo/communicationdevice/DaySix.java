package com.wytzig.lw.nl.advent.twentytwentytwo.communicationdevice;

import com.wytzig.lw.nl.advent.Day;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaySix extends Day {

    private String tempMarker = "";

    private void processStringAsStream(String datastreamBuffer, boolean packageMarker) {
        char[] inputCharacterList = datastreamBuffer.toCharArray();

        for (int i = 0; i < inputCharacterList.length; i++) {
            this.tempMarker += inputCharacterList[i];

            if (packageMarker) {
                if (checkMarker(4, i)) return; //package
            } else {
                if (checkMarker(14, i)) return; //message
            }
        }
    }

    private boolean checkMarker(int markerLength, int currentPosition) {
        if (this.tempMarker.length() >= markerLength) { // we need to check the marker
            if (isValidMarker(this.tempMarker)) {
//                System.out.println("hooraayyy we have a marker: " + this.tempMarker + ". This occurred after: " + (currentPosition + 1) + " char checks");
                this.tempMarker = ""; // clean global var
                return true; // we have found a marker
            }
        }
        if (this.tempMarker.length() == markerLength) { // remove first char
            this.tempMarker = this.tempMarker.substring(1);
        }
        return false;
    }

    /**
     * A package marker is a string of 4 characters that has no repeating letters
     * A message marker is a string of 14 characters that has no repeating letters
     *
     * @param possibleMarker
     */
    private boolean isValidMarker(String possibleMarker) {
        assert possibleMarker != null || !possibleMarker.isEmpty() || !possibleMarker.isBlank();

        boolean result = true;

        for (int i = 0; i <= possibleMarker.length() - 1; i++) {
            Matcher matcher = Pattern.compile(possibleMarker.charAt(i) + "").matcher(possibleMarker.substring(i + 1));
            int count = 0;

            while (matcher.find()) {
                count++;
            }
            if (count == 1) { // there were multiple occurrences!
                return false;
            }
        }
        return result;
    }

    @Override
    public boolean getAnswerFromExample() {
        processStringAsStream("mjqjpqmgbljsphdztnvjfqwrcgsmlb", true);
        processStringAsStream("bvwbjplbgvbhsrlpgdmjqwftvncz", true);
        processStringAsStream("nppdvjthqldpwncqszvftbrmjlhg", true);
        processStringAsStream("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", true);
        processStringAsStream("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", true);
        System.out.println("");
        return true;
    }

    @Override
    public boolean getAnswerForQuestion() {
        processStringAsStream("bjbffsfnsnppzpphvhjvjtjmjwjrjdjffwrfrvvrqrrqwrrqpqhqnnddvccrbbwcwbcbclclhlzlznntrrzffctcggzqgqtgqtgtrgttlhttgstgtsgsfsnsddsvdsvddrzrvrnvnrvnrnmrrvfvbfbnbmmtbbgpgtptjptpctpccmccgbccqbcqczqccdssfqfzzjgzzvcvgggrjggncgctgtjjpttqtrrvmrvmmzzfcffpgfgfqggbwgghcctllfhlffbbcffspfpcplpjjlwldwldlpddwzzlqzqfzzcwcmwwcddhgddstsnsjsvjsvvndndsnnclcvcpvpwpqwpqwqllcjcsjjbppfdftfrrpwwqtqtvtllrsrhhczzgllsbsvsttbsszzgwgjwjqwjwvvcmcbczbbgppghghgshhvmhmvvvflllllsrsqsbbfsshhrhddcncbnnrfnnbtbftfltftdtndtdtcdcbdcbchhtddhhvbvsbstsjsjppmpjpttmjjvtjvvdcctcbbbbqzzssfdsdrdwdpplspllphpnhnshnncwnnhlnhhvvpttfftwfwjfjzjsjddjldjlddvzzfzczrzjrzrhzhshslhsllmcllhhthrttfssnqnjnbbzfbbmpmlplhlttmzzwrwjrjppzmpmrprcprplrprmrvrvqrrnlnccswwvggvgcgddlrlrccqhhgvgnvvmlmmcqqhrqrwqwsswgssfjjgvjvppfffhjhrhfhhlphpmpzmpmlppcspcpgpnpddcmcllwvvqfqbbpbcchjjpzpzbbhbzhhrrzrhzhphqphhqvqttmhhbvbcbcmbbfgbbmnmncmnmvnvffgdfggvhvthvhqqdwwvmvlmljjjvsjswjwzwjjqmqrmqmlljqqjvqvtvlldjjfbbpbvbttqhhgrrcssfdsdccrncrncnmnvvmccnrrrtctjtsjttrmrhhvdhdrdjdpdhphsppnttnhhvdvvztvtftsfsrfrppsggfbgbbvbmmjgjrjttfnngttscclzcztctcltcllsmllggbfbhffjljhhbjjjgddzdvdvrvzrrgqgllnvllnccqjqhhwrhhtfttfpfsfvfqvqgvgpppjjhzzcszczbcbtblltlffdfwddfsspgprgpgjgdgsgcccrllbzbqzbzwbwwtmwwvpvlpljlsjssfnfqfzqffthtjtptvptvvmlvlzzdnznwnddjtjpptnpnccbsccjmjqqcfcdddwtdtftntzzpbbbhcbblglttrmmclcdchhzttjwtwztwzwzczfccmrmcrmrsrnsrnrsnrrfmmmcpmmjtjrrwssvdssrvrqvrvcrchrhfhpprwprwpwtttvrtvrvffdcfcssfrfbbvsslvvhphrrwggssjtjbttqtllnmlnljlmmtllfjjtjtpjttbwbswsnwnnjdjbblfbfmmblmmwnmnncjcwwhzzdffvppvmmtzzrhrchhtjhttcssvnsnvnhvvdgvvvgtvtqtgqqzrzbzqzgqgmqmtqqztqqgllchlclwwbwrrwprwprrlgrgwggjhggtgmtggjddfhdddnzztrtjrjprpwrwttqzqnzzfnfcnfcftflfttvbvpbpllrtltslttlddbzdbzzfjfrjfjcjhjssbcsczcnznlzzggdccllhbhpbhbjbwjbwjwtwffptpqqqmssrlrddwqwqdqfqjqwqtqhtsrgvsdtrjmhtgrwvwrbfqtgvjbwphbrszdcgtcpqqrcqtzvzjstzpbmwrqlrcsmlnqpsprsfnpqqsdzbfglcshtjpphmchdzggrcjwttwlzdffgpswzfjdcgzntgzsqvjdnwwwwmtjvpqjgmltmstzztpzflfdhbhhljgdmthnrdzhmtwcmpsjnlgwcvnwdbdrbhcsscgwtptzrmqcwdcmsssmqjpnvclhhbgsjrmqgvvqhgmhzmnpqtczqwmnpvvpdhdtdpdsrmzwtsfchzmdlggrnvwcfbfmrgffssdjjlwbdvjqqwddgmgfwvbzldccwnwrnltcrmblwqswjslnsjtfqvssdrdtpwptdtvtdwhgtgqnmhqfljjjsdgwmptbctjtpdhzmtshgdwnnhfjthmhdrqqqprrdwhvsfwfbvwtfvhgglfphzwjqffwcclbpmtcqzmtjmswscngtbmbdsvfzfbgwvhwlhtgdsnscnrssdqzvhmhplqppzrgdncfvvpnzhgnjrvcmhrqmzvzmdhhpjmrrnwfrhdgqdhvvstbldrgdcwbgjvcwhfrpbgrnvgcszhpbbgvqnvvrrcgprtsftjqtnrbqrzspmzpnchbrbbbpnjdllhnnbcfdsjjhhjcrvvtsgnnfvczvqgvbgphzzjcczsgtlvfrddzlvwdfhprnsvrnzdcfqsbfhcmnrgmrfqwcblbzgrpnvbtrqqnnfslfllfsmrrfsthfzgrwswdprzcswgrjcpzwfhzbhpmsjjtsgcqpnhtwpvpcbpttdpcftrqsbtgtspdhlvmphvnglsdntqfzcrwvvzsmjftjpgjglnnjhnpbhpcmwshdrfbczwtmtslcpmnpngvhlccvtwrsglrrfcmngshtjlnvrtqpfngrrtvhhvmnbwpjtwplfnmfqrbzzqzwchthjbbrpgdppmsjlbljrzqvhmsbrtwglgwnhmmdwpmvmjqqrhtmjjmcnbgtpbbqbnphzhwfhzddqbhqhtmwvffjdcfjmwjjdrqwsfzfrrwlmhndhdvrsdqtmccdqgppwpfrtcgzzwczfblvtjhhdjmdlldbtwthfdpjhpsgbcjjznmwdgnczbnfdfslhsjcjnthgsjlslbcvvqgqbstdwlqllpmmtqlqrbtnvphvwhbshhpdzfbclsqgdmhrnjmbwjzwzdtqswzgmnmwcqcmtpnjzzcrqftvnrdqghszchhmnvlvmcmblpcqnspsjthgqrdpbrzvwtfmnfdcfgwtlvpvwjdwzdvqvgdrcqvzwlbmcwmbsqfhzmwfqmjvgjtsprwbbsrldnwmvhrtsmcdsbftpvcsmpnlmlggmlrgjfvljmpfldftqhjmqqhwfpjtzrrhtlrmmstjphtmldslnnmfhnccrpgjmrbffcvgvmghhnpqhpvdqmdzqcjtcjplhlffwgslpsfzpwqsfpngscdlszlpctpqgdmvwfdfgpwrpltvlwrzrgjjjnjtrwctjsnbtpbfbgqzftmjhfrzrtmtnztlhwwgqnvmfnrshfcdswbqnlrqvtgjdzmqqcdgpwjlgfwnnnjsmmtfbvpwqvnjdjphclnvjntqlfwdppjgcvlcjmfdsbtgngcglmdgsgzwdvsqlvgwcrjtttgdmrlthhwhnnrvvrjgqzqmbcbmhdwmndhjstlmbtwjbgmlrqqcmqzjzcbbfrqrqlmvvgfrdtrwrpgcfsrnjdbfddwgwqrlpvfjgnjjnrlzpbtnjphlqzmdwnqhvblmwzvtnsvbcgqdpmgvchqmgjmbvrfwmmzlchhbqrfmvdffczcsjlhjrmmlmdztmltszrjlrgjwrlfwvlgqtqznnscbqgdzbvdnnjbfmcztjvbgbfmdhvrjgjcngtpzndpnpwwldlfrtqhwpfwphrgdzjvslnbpmrvjpcjpbbsmpwvzmldrspmrlbsptzfdngcscsllswzccjzlmbglsrthvbzznzpjdswhqncmrpnqhzggzzfvhlgqbvlmfsqglpphhswhjbpqnqfpzltmhndmmzclwfmlqztvrqdzfqjpdhttgshjwffdcchmvrwmblpzffbgwrgnqhhvvsvlwnzmmhjwrszpfdsncjwllrnzrsfjsrdgnrbjqlrvpmzbstlqdznhjgbslzmplnqprwqgddjlwzbtrmfsfdlggddqrccztjffvbnsmfdzdhrgsflffmmjtjlbtnfcwhwzdsnbbphbjlrfrddbpncjrtglsnrppdbznrbjqqzdswnhvssffhjzrwnmlvmwmljnhtsnplpjdjpqzbbmzzfcmpm", true);
        System.out.println("");
        return true;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        processStringAsStream("mjqjpqmgbljsphdztnvjfqwrcgsmlb", false);
        processStringAsStream("bvwbjplbgvbhsrlpgdmjqwftvncz", false);
        processStringAsStream("nppdvjthqldpwncqszvftbrmjlhg", false);
        processStringAsStream("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", false);
        processStringAsStream("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", false);

        System.out.println("");
        return true;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        processStringAsStream("bjbffsfnsnppzpphvhjvjtjmjwjrjdjffwrfrvvrqrrqwrrqpqhqnnddvccrbbwcwbcbclclhlzlznntrrzffctcggzqgqtgqtgtrgttlhttgstgtsgsfsnsddsvdsvddrzrvrnvnrvnrnmrrvfvbfbnbmmtbbgpgtptjptpctpccmccgbccqbcqczqccdssfqfzzjgzzvcvgggrjggncgctgtjjpttqtrrvmrvmmzzfcffpgfgfqggbwgghcctllfhlffbbcffspfpcplpjjlwldwldlpddwzzlqzqfzzcwcmwwcddhgddstsnsjsvjsvvndndsnnclcvcpvpwpqwpqwqllcjcsjjbppfdftfrrpwwqtqtvtllrsrhhczzgllsbsvsttbsszzgwgjwjqwjwvvcmcbczbbgppghghgshhvmhmvvvflllllsrsqsbbfsshhrhddcncbnnrfnnbtbftfltftdtndtdtcdcbdcbchhtddhhvbvsbstsjsjppmpjpttmjjvtjvvdcctcbbbbqzzssfdsdrdwdpplspllphpnhnshnncwnnhlnhhvvpttfftwfwjfjzjsjddjldjlddvzzfzczrzjrzrhzhshslhsllmcllhhthrttfssnqnjnbbzfbbmpmlplhlttmzzwrwjrjppzmpmrprcprplrprmrvrvqrrnlnccswwvggvgcgddlrlrccqhhgvgnvvmlmmcqqhrqrwqwsswgssfjjgvjvppfffhjhrhfhhlphpmpzmpmlppcspcpgpnpddcmcllwvvqfqbbpbcchjjpzpzbbhbzhhrrzrhzhphqphhqvqttmhhbvbcbcmbbfgbbmnmncmnmvnvffgdfggvhvthvhqqdwwvmvlmljjjvsjswjwzwjjqmqrmqmlljqqjvqvtvlldjjfbbpbvbttqhhgrrcssfdsdccrncrncnmnvvmccnrrrtctjtsjttrmrhhvdhdrdjdpdhphsppnttnhhvdvvztvtftsfsrfrppsggfbgbbvbmmjgjrjttfnngttscclzcztctcltcllsmllggbfbhffjljhhbjjjgddzdvdvrvzrrgqgllnvllnccqjqhhwrhhtfttfpfsfvfqvqgvgpppjjhzzcszczbcbtblltlffdfwddfsspgprgpgjgdgsgcccrllbzbqzbzwbwwtmwwvpvlpljlsjssfnfqfzqffthtjtptvptvvmlvlzzdnznwnddjtjpptnpnccbsccjmjqqcfcdddwtdtftntzzpbbbhcbblglttrmmclcdchhzttjwtwztwzwzczfccmrmcrmrsrnsrnrsnrrfmmmcpmmjtjrrwssvdssrvrqvrvcrchrhfhpprwprwpwtttvrtvrvffdcfcssfrfbbvsslvvhphrrwggssjtjbttqtllnmlnljlmmtllfjjtjtpjttbwbswsnwnnjdjbblfbfmmblmmwnmnncjcwwhzzdffvppvmmtzzrhrchhtjhttcssvnsnvnhvvdgvvvgtvtqtgqqzrzbzqzgqgmqmtqqztqqgllchlclwwbwrrwprwprrlgrgwggjhggtgmtggjddfhdddnzztrtjrjprpwrwttqzqnzzfnfcnfcftflfttvbvpbpllrtltslttlddbzdbzzfjfrjfjcjhjssbcsczcnznlzzggdccllhbhpbhbjbwjbwjwtwffptpqqqmssrlrddwqwqdqfqjqwqtqhtsrgvsdtrjmhtgrwvwrbfqtgvjbwphbrszdcgtcpqqrcqtzvzjstzpbmwrqlrcsmlnqpsprsfnpqqsdzbfglcshtjpphmchdzggrcjwttwlzdffgpswzfjdcgzntgzsqvjdnwwwwmtjvpqjgmltmstzztpzflfdhbhhljgdmthnrdzhmtwcmpsjnlgwcvnwdbdrbhcsscgwtptzrmqcwdcmsssmqjpnvclhhbgsjrmqgvvqhgmhzmnpqtczqwmnpvvpdhdtdpdsrmzwtsfchzmdlggrnvwcfbfmrgffssdjjlwbdvjqqwddgmgfwvbzldccwnwrnltcrmblwqswjslnsjtfqvssdrdtpwptdtvtdwhgtgqnmhqfljjjsdgwmptbctjtpdhzmtshgdwnnhfjthmhdrqqqprrdwhvsfwfbvwtfvhgglfphzwjqffwcclbpmtcqzmtjmswscngtbmbdsvfzfbgwvhwlhtgdsnscnrssdqzvhmhplqppzrgdncfvvpnzhgnjrvcmhrqmzvzmdhhpjmrrnwfrhdgqdhvvstbldrgdcwbgjvcwhfrpbgrnvgcszhpbbgvqnvvrrcgprtsftjqtnrbqrzspmzpnchbrbbbpnjdllhnnbcfdsjjhhjcrvvtsgnnfvczvqgvbgphzzjcczsgtlvfrddzlvwdfhprnsvrnzdcfqsbfhcmnrgmrfqwcblbzgrpnvbtrqqnnfslfllfsmrrfsthfzgrwswdprzcswgrjcpzwfhzbhpmsjjtsgcqpnhtwpvpcbpttdpcftrqsbtgtspdhlvmphvnglsdntqfzcrwvvzsmjftjpgjglnnjhnpbhpcmwshdrfbczwtmtslcpmnpngvhlccvtwrsglrrfcmngshtjlnvrtqpfngrrtvhhvmnbwpjtwplfnmfqrbzzqzwchthjbbrpgdppmsjlbljrzqvhmsbrtwglgwnhmmdwpmvmjqqrhtmjjmcnbgtpbbqbnphzhwfhzddqbhqhtmwvffjdcfjmwjjdrqwsfzfrrwlmhndhdvrsdqtmccdqgppwpfrtcgzzwczfblvtjhhdjmdlldbtwthfdpjhpsgbcjjznmwdgnczbnfdfslhsjcjnthgsjlslbcvvqgqbstdwlqllpmmtqlqrbtnvphvwhbshhpdzfbclsqgdmhrnjmbwjzwzdtqswzgmnmwcqcmtpnjzzcrqftvnrdqghszchhmnvlvmcmblpcqnspsjthgqrdpbrzvwtfmnfdcfgwtlvpvwjdwzdvqvgdrcqvzwlbmcwmbsqfhzmwfqmjvgjtsprwbbsrldnwmvhrtsmcdsbftpvcsmpnlmlggmlrgjfvljmpfldftqhjmqqhwfpjtzrrhtlrmmstjphtmldslnnmfhnccrpgjmrbffcvgvmghhnpqhpvdqmdzqcjtcjplhlffwgslpsfzpwqsfpngscdlszlpctpqgdmvwfdfgpwrpltvlwrzrgjjjnjtrwctjsnbtpbfbgqzftmjhfrzrtmtnztlhwwgqnvmfnrshfcdswbqnlrqvtgjdzmqqcdgpwjlgfwnnnjsmmtfbvpwqvnjdjphclnvjntqlfwdppjgcvlcjmfdsbtgngcglmdgsgzwdvsqlvgwcrjtttgdmrlthhwhnnrvvrjgqzqmbcbmhdwmndhjstlmbtwjbgmlrqqcmqzjzcbbfrqrqlmvvgfrdtrwrpgcfsrnjdbfddwgwqrlpvfjgnjjnrlzpbtnjphlqzmdwnqhvblmwzvtnsvbcgqdpmgvchqmgjmbvrfwmmzlchhbqrfmvdffczcsjlhjrmmlmdztmltszrjlrgjwrlfwvlgqtqznnscbqgdzbvdnnjbfmcztjvbgbfmdhvrjgjcngtpzndpnpwwldlfrtqhwpfwphrgdzjvslnbpmrvjpcjpbbsmpwvzmldrspmrlbsptzfdngcscsllswzccjzlmbglsrthvbzznzpjdswhqncmrpnqhzggzzfvhlgqbvlmfsqglpphhswhjbpqnqfpzltmhndmmzclwfmlqztvrqdzfqjpdhttgshjwffdcchmvrwmblpzffbgwrgnqhhvvsvlwnzmmhjwrszpfdsncjwllrnzrsfjsrdgnrbjqlrvpmzbstlqdznhjgbslzmplnqprwqgddjlwzbtrmfsfdlggddqrccztjffvbnsmfdzdhrgsflffmmjtjlbtnfcwhwzdsnbbphbjlrfrddbpncjrtglsnrppdbznrbjqqzdswnhvssffhjzrwnmlvmwmljnhtsnplpjdjpqzbbmzzfcmpm", false);
        System.out.println("");
        return true;
    }
}
