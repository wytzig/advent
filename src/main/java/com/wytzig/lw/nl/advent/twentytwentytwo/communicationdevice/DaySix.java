package com.wytzig.lw.nl.advent.twentytwentytwo.communicationdevice;

import com.wytzig.lw.nl.advent.Day;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DaySix implements Day {

    private void processStringAsStream(String datastreamBuffer) {
        char[] inputCharacterList = datastreamBuffer.toCharArray();

        String tempMarkerBuilder = "";
        for(int i = 0; i < inputCharacterList.length; i++) {
            tempMarkerBuilder += inputCharacterList[i];
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
            System.out.println("Silently fail overflow exception: " + e);
        } finally {
            return result;
        }
    }

    @Override
    public boolean getAnswerFromExample() {
        processStringAsStream("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        processStringAsStream("bvwbjplbgvbhsrlpgdmjqwftvncz");
        processStringAsStream("nppdvjthqldpwncqszvftbrmjlhg");
        processStringAsStream("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        processStringAsStream("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        return true;
    }

    @Override
    public boolean getAnswerForQuestion() {
        processStringAsStream("bjbffsfnsnppzpphvhjvjtjmjwjrjdjffwrfrvvrqrrqwrrqpqhqnnddvccrbbwcwbcbclclhlzlznntrrzffctcggzqgqtgqtgtrgttlhttgstgtsgsfsnsddsvdsvddrzrvrnvnrvnrnmrrvfvbfbnbmmtbbgpgtptjptpctpccmccgbccqbcqczqccdssfqfzzjgzzvcvgggrjggncgctgtjjpttqtrrvmrvmmzzfcffpgfgfqggbwgghcctllfhlffbbcffspfpcplpjjlwldwldlpddwzzlqzqfzzcwcmwwcddhgddstsnsjsvjsvvndndsnnclcvcpvpwpqwpqwqllcjcsjjbppfdftfrrpwwqtqtvtllrsrhhczzgllsbsvsttbsszzgwgjwjqwjwvvcmcbczbbgppghghgshhvmhmvvvflllllsrsqsbbfsshhrhddcncbnnrfnnbtbftfltftdtndtdtcdcbdcbchhtddhhvbvsbstsjsjppmpjpttmjjvtjvvdcctcbbbbqzzssfdsdrdwdpplspllphpnhnshnncwnnhlnhhvvpttfftwfwjfjzjsjddjldjlddvzzfzczrzjrzrhzhshslhsllmcllhhthrttfssnqnjnbbzfbbmpmlplhlttmzzwrwjrjppzmpmrprcprplrprmrvrvqrrnlnccswwvggvgcgddlrlrccqhhgvgnvvmlmmcqqhrqrwqwsswgssfjjgvjvppfffhjhrhfhhlphpmpzmpmlppcspcpgpnpddcmcllwvvqfqbbpbcchjjpzpzbbhbzhhrrzrhzhphqphhqvqttmhhbvbcbcmbbfgbbmnmncmnmvnvffgdfggvhvthvhqqdwwvmvlmljjjvsjswjwzwjjqmqrmqmlljqqjvqvtvlldjjfbbpbvbttqhhgrrcssfdsdccrncrncnmnvvmccnrrrtctjtsjttrmrhhvdhdrdjdpdhphsppnttnhhvdvvztvtftsfsrfrppsggfbgbbvbmmjgjrjttfnngttscclzcztctcltcllsmllggbfbhffjljhhbjjjgddzdvdvrvzrrgqgllnvllnccqjqhhwrhhtfttfpfsfvfqvqgvgpppjjhzzcszczbcbtblltlffdfwddfsspgprgpgjgdgsgcccrllbzbqzbzwbwwtmwwvpvlpljlsjssfnfqfzqffthtjtptvptvvmlvlzzdnznwnddjtjpptnpnccbsccjmjqqcfcdddwtdtftntzzpbbbhcbblglttrmmclcdchhzttjwtwztwzwzczfccmrmcrmrsrnsrnrsnrrfmmmcpmmjtjrrwssvdssrvrqvrvcrchrhfhpprwprwpwtttvrtvrvffdcfcssfrfbbvsslvvhphrrwggssjtjbttqtllnmlnljlmmtllfjjtjtpjttbwbswsnwnnjdjbblfbfmmblmmwnmnncjcwwhzzdffvppvmmtzzrhrchhtjhttcssvnsnvnhvvdgvvvgtvtqtgqqzrzbzqzgqgmqmtqqztqqgllchlclwwbwrrwprwprrlgrgwggjhggtgmtggjddfhdddnzztrtjrjprpwrwttqzqnzzfnfcnfcftflfttvbvpbpllrtltslttlddbzdbzzfjfrjfjcjhjssbcsczcnznlzzggdccllhbhpbhbjbwjbwjwtwffptpqqqmssrlrddwqwqdqfqjqwqtqhtsrgvsdtrjmhtgrwvwrbfqtgvjbwphbrszdcgtcpqqrcqtzvzjstzpbmwrqlrcsmlnqpsprsfnpqqsdzbfglcshtjpphmchdzggrcjwttwlzdffgpswzfjdcgzntgzsqvjdnwwwwmtjvpqjgmltmstzztpzflfdhbhhljgdmthnrdzhmtwcmpsjnlgwcvnwdbdrbhcsscgwtptzrmqcwdcmsssmqjpnvclhhbgsjrmqgvvqhgmhzmnpqtczqwmnpvvpdhdtdpdsrmzwtsfchzmdlggrnvwcfbfmrgffssdjjlwbdvjqqwddgmgfwvbzldccwnwrnltcrmblwqswjslnsjtfqvssdrdtpwptdtvtdwhgtgqnmhqfljjjsdgwmptbctjtpdhzmtshgdwnnhfjthmhdrqqqprrdwhvsfwfbvwtfvhgglfphzwjqffwcclbpmtcqzmtjmswscngtbmbdsvfzfbgwvhwlhtgdsnscnrssdqzvhmhplqppzrgdncfvvpnzhgnjrvcmhrqmzvzmdhhpjmrrnwfrhdgqdhvvstbldrgdcwbgjvcwhfrpbgrnvgcszhpbbgvqnvvrrcgprtsftjqtnrbqrzspmzpnchbrbbbpnjdllhnnbcfdsjjhhjcrvvtsgnnfvczvqgvbgphzzjcczsgtlvfrddzlvwdfhprnsvrnzdcfqsbfhcmnrgmrfqwcblbzgrpnvbtrqqnnfslfllfsmrrfsthfzgrwswdprzcswgrjcpzwfhzbhpmsjjtsgcqpnhtwpvpcbpttdpcftrqsbtgtspdhlvmphvnglsdntqfzcrwvvzsmjftjpgjglnnjhnpbhpcmwshdrfbczwtmtslcpmnpngvhlccvtwrsglrrfcmngshtjlnvrtqpfngrrtvhhvmnbwpjtwplfnmfqrbzzqzwchthjbbrpgdppmsjlbljrzqvhmsbrtwglgwnhmmdwpmvmjqqrhtmjjmcnbgtpbbqbnphzhwfhzddqbhqhtmwvffjdcfjmwjjdrqwsfzfrrwlmhndhdvrsdqtmccdqgppwpfrtcgzzwczfblvtjhhdjmdlldbtwthfdpjhpsgbcjjznmwdgnczbnfdfslhsjcjnthgsjlslbcvvqgqbstdwlqllpmmtqlqrbtnvphvwhbshhpdzfbclsqgdmhrnjmbwjzwzdtqswzgmnmwcqcmtpnjzzcrqftvnrdqghszchhmnvlvmcmblpcqnspsjthgqrdpbrzvwtfmnfdcfgwtlvpvwjdwzdvqvgdrcqvzwlbmcwmbsqfhzmwfqmjvgjtsprwbbsrldnwmvhrtsmcdsbftpvcsmpnlmlggmlrgjfvljmpfldftqhjmqqhwfpjtzrrhtlrmmstjphtmldslnnmfhnccrpgjmrbffcvgvmghhnpqhpvdqmdzqcjtcjplhlffwgslpsfzpwqsfpngscdlszlpctpqgdmvwfdfgpwrpltvlwrzrgjjjnjtrwctjsnbtpbfbgqzftmjhfrzrtmtnztlhwwgqnvmfnrshfcdswbqnlrqvtgjdzmqqcdgpwjlgfwnnnjsmmtfbvpwqvnjdjphclnvjntqlfwdppjgcvlcjmfdsbtgngcglmdgsgzwdvsqlvgwcrjtttgdmrlthhwhnnrvvrjgqzqmbcbmhdwmndhjstlmbtwjbgmlrqqcmqzjzcbbfrqrqlmvvgfrdtrwrpgcfsrnjdbfddwgwqrlpvfjgnjjnrlzpbtnjphlqzmdwnqhvblmwzvtnsvbcgqdpmgvchqmgjmbvrfwmmzlchhbqrfmvdffczcsjlhjrmmlmdztmltszrjlrgjwrlfwvlgqtqznnscbqgdzbvdnnjbfmcztjvbgbfmdhvrjgjcngtpzndpnpwwldlfrtqhwpfwphrgdzjvslnbpmrvjpcjpbbsmpwvzmldrspmrlbsptzfdngcscsllswzccjzlmbglsrthvbzznzpjdswhqncmrpnqhzggzzfvhlgqbvlmfsqglpphhswhjbpqnqfpzltmhndmmzclwfmlqztvrqdzfqjpdhttgshjwffdcchmvrwmblpzffbgwrgnqhhvvsvlwnzmmhjwrszpfdsncjwllrnzrsfjsrdgnrbjqlrvpmzbstlqdznhjgbslzmplnqprwqgddjlwzbtrmfsfdlggddqrccztjffvbnsmfdzdhrgsflffmmjtjlbtnfcwhwzdsnbbphbjlrfrddbpncjrtglsnrppdbznrbjqqzdswnhvssffhjzrwnmlvmwmljnhtsnplpjdjpqzbbmzzfcmpm");
        return false;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        return false;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        return false;
    }
}
