package WeeklyContest254;

public class First {
    public static void main(String[] args){
        String[] patterns = {"iiku"};
        String word = "iiiku";
        System.out.println(numOfStrings(patterns, word));
    }
//["hvzoo","r","hyjcrgzr","yvqahvz","org","yvqahvz","org","oor","gxe","zo","ahvzoo","ahvzo","r","o","caviikty","pkxlcaams"]
//"tyvqahvzoorg" 12
/*["e","ulhjriiikuwwi","odtbmiyiv","iiku","o","nao","ilrbdhfvndjaxohexcynpgocoqorifjngaurokumcqqkirqp","zmt","tuxulhjriiikuwwibjpodtbmiyiv","lhjriiikuwwibjpodtbmiyi","qjnwwkfqhztiyqayiabjjzyqhumh","lhjriiikuwwibjpodtbmiyiv","oyaloibpkqpyubftinknjraptsuqgejucpfigc","fdqvajkfornietcdvxltbktlkg","bcxslqwrjaabvywpynzfojetmnnwrurimjgwl","ncvvyhbznxrxoonfrzfmecfdnrvikffpvrc","gxvzmtuxulhjriiikuwwibjpodtbmiyi","ozuwzgetoddakvjwiwzocpwpiavcyclxhlguhfqtpbk","ktwqukguxobakxvbitkkdemvlmqypd","gxvzmtuxulhjri","xulhjriiiku","sjemhhtbqastmbtbvsfnuygqfypmmi","gqfmyqbjcvuxsjdaeffwthlelb","kuwwibjpodtbmiyivse","ydwiabsimbkdwmsvgp","ixrzoktohtadgblem","uicfykignmptxodjd","kecqujgjynq","sruqpwjevngokrbyi","rijyzrhrygxvzmtuxulhjriii","gsljxjrmkzbwaqdgmwysnblp","arkmbbafkziemddeqripnyjoavmoaxtn","gxhijktottj","ibjpodtbmiyivse","j","qzvmjstehwibuqcqlzdam","ikuwwibjpodt","mnrp","pduagikyudhcvdnqoaadqvvmhluywfsstqnawfmq","vse","iyiv","miyivs","qdfrbkhffkksgtjpnbgvqtrnigbnoacmqkepllouhqpgskpupy","wxbqfmzvmmffwtwjhjpuitcfmknnuwdtamtutiukmpsxzu","odtbmiyi","hrygxvzmtuxulhjriiiku","yzrhrygxvzmtuxu","se","gixgfjtunbltzcwgkrheavilcvektnsizvrrabmysx","hjriiikuwwibj","ahaeorlnaqkk","gvnyr","tynqzmrvdjaznuji","jbwybcttaspwsbieawybfqxsiwxulwkouezkhbauadatb","uwwibjpodt","gxv","zrhrygxvzmtuxulhjriiikuwwib","wivvuywmwchszzctw","lijcroypqr","mrx","m","ygngqghhza","riiikuwwibjpodtbmiyivs","tymtjqykindweexrfztizyagijnxntrcrcy","vse","kntxszudqpmtlrxzspcfivbrwonejzywv","ygxvzmtuxulh","wsnnrijyzrhrygxvzmtuxulhjriiik","zpymedyxskwqddvxlycxvq","qdkm","gxvzmtuxu","snnrijyzrhrygxvzmtuxulhjriiikuwwibjpo","iyivserr","yzrhrygxvzmt","rygxvzmtuxulhjrii","snnrijyzrhrygxvzmtuxul","gxvzmtuxulhjriiikuwwibjpodtbmiyivserr","kuwwibjpodt","ibjpodtbmiy","mtuxulhjriii","zrhrygxvzmtu","qxjvgdyuqt","rygxv","gnwmvzqhrodzqdvdexgupqbzogcpmtfq","oleibiotmojkqexnnlx","dtb","jjividhfhdixcvyduyunoiiipyvi","podtb","jpodtbmiyi","iiku","od","kuwwibjpodtb","b","irugjrzvsfp","wsnnrijyzrhrygxvzmtuxulhjrii","jriiikuwwibjpodtbmi"]
"wsnnrijyzrhrygxvzmtuxulhjriiikuwwibjpodtbmiyivserr"
*/
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        boolean find = false;
        for(String str : patterns){
            find = false;
            for(int i = 0; i < word.length(); i++){
                int index = 0;
                for(int j = i; j < word.length(); j++){
                    if(str.charAt(index) != word.charAt(j)) break;
                    index++;
                    if(index == str.length()){
                        count++;
                        find = true;
                        break;
                    }
                    if(find) break;
                }
            }
        }
        return count;
    }
}
