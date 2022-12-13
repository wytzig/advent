package com.wytzig.lw.nl.advent.twentytwentytwo.communicationdevice;

import com.wytzig.lw.nl.advent.Day;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaySix implements Day {

    private void processStringAsStream(String datastreamBuffer, boolean packageMarker) {
        char[] inputCharacterList = datastreamBuffer.toCharArray();

        String tempMarkerBuilder = "";
        for(int i = 0; i < inputCharacterList.length; i++) {
            tempMarkerBuilder += inputCharacterList[i];
            if(packageMarker) {
                if(tempMarkerBuilder.length() >= 4) { // we need to check the marker
                    if(isValidMarker(tempMarkerBuilder)) {
                        System.out.println("hooraayyy we have a marker: " + tempMarkerBuilder + ". This occurred after: " + (i + 1) + " char checks");
                        return;
                    }
                }
                if(tempMarkerBuilder.length() == 4) { // remove first char
                    tempMarkerBuilder = tempMarkerBuilder.substring(1);
                }
            }
            else {
                if(tempMarkerBuilder.length() >= 14) { // we need to check the marker
                    if(isValidMarker(tempMarkerBuilder)) {
                        System.out.println("hooraayyy we have a marker: " + tempMarkerBuilder + ". This occurred after: " + (i + 1) + " char checks");
                        return;
                    }
                }
                if(tempMarkerBuilder.length() == 14) { // remove first char
                    tempMarkerBuilder = tempMarkerBuilder.substring(1);
                }
            }


        }
    }

    /**
     * A marker is a string of 4 characters that has no repeating letters
     * @param possibleMarker
     * @return
     */
    private boolean isValidMarker(String possibleMarker) {
        assert possibleMarker != null || !possibleMarker.isEmpty() || !possibleMarker.isBlank();

        boolean result = false;

        try {
            for(int i = 0; i <= possibleMarker.length(); i++) {
                Matcher matcher= Pattern.compile(possibleMarker.charAt(i) + "").matcher(possibleMarker.substring(i + 1));
                int count = 0;

                while (matcher.find()) {
                    count++;
                }
                if(count == 0) {
                    result = true; // sure but also check next...
                }
                if(count == 1) { // there were multiple occurrences!
                    result = false;
                    return result;
                }
            }
            return result;
        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Silently fail overflow exception: " + e);
        } finally {
            return result;
        }
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
        return false;
    }
}
