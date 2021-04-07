package com.bahadir;

import java.sql.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Aşağıdaki ifadelerin geçerli olup olmadığını belirlemek için stack sınıfınızı Java programında yazın.
Geçerli ifadeler şu karakterlerden oluşur: "X () []’ (yani: çift tırnak, büyük X, açık parantez, kapalı
parantez, açık köşeli parantez, kapalı köşeli parantez, tek tırnak ve boşluk.) Boşluklar herhangi bir yerde olabilir.
X olmayan karakterler mutlaka eşleşmelidir.

Örneğin ([]).
Eğer bir tırnak ya da çift tırnak gelirse ve stack sonu tek tırnak ile eşleşiyorsa bunu bir son olarak düşünün.
Aksi durumda bunu bir başlangıç sembolü olarak alın.

Örnekler:
XXXX                            geçerli
XXXX                            geçerli
X(XX)X                          geçerli
(XX)                            geçerli
(XX)[]                          geçerli
(["''"])                        geçerli
([)]                            geçersiz
"XXXX XXXX"                     geçerli
"XXXX XXXX                      geçersiz
"(XXXX) (XXX)"                  geçerli
"XXXX" X "XXXX"                 geçerli
"XXX XXX (X) XXX XXX "XXX""     geçerli

 */

public class Main {

    // Şimdi parantez tiplerini tutacak 1 map ve 1 set değişken oluşturuyoruz. Ve bunlara parantez tiplerimizi ekliyoruz.

    private static final Map<Character, Character> matchMap = new HashMap<>();
    private static final Set<Character> openParentSet = new HashSet<>();

        static {
            matchMap.put(')', '(');
            matchMap.put(']', '[');
            matchMap.put('}', '{');
            matchMap.put('"', '"');
            openParentSet.addAll(matchMap.values());
        }

    public static void main(String[] args) {

        String example = "(XX)[]";
        String example2 = "([)]";

        System.out.println(matching(example));
        System.out.println(matching(example2));


    }

    public static boolean matching(String input){
        try {
            Stack<Character> parenStack = new Stack<>();

            for (int i=0; i < input.length();i++){
                char ch = input.charAt(i);
                if (openParentSet.contains(ch)){
                    parenStack.push(ch);
                }
                if (matchMap.containsKey(ch)){
                    Character lastParen = parenStack.pop();
                    if (lastParen != matchMap.get(ch)) {
                        return false;
                    }
                }
            }
            return parenStack.isEmpty();
        } catch (StackOverflowError error) {
            System.out.println("Error: "+ error);
        }
        return false;
    }
}

//  https://serkanerip.medium.com/stack-ile-parantezlerin-kontrolü-d894497c9918