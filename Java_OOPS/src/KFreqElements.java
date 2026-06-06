import jdk.jfr.Frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFreqElements {
    public static void main(String[] args) {
        Map<String,Integer> freqMap = new HashMap<>();
        freqMap.put("hello",2);
        freqMap.put("brain",4);
        freqMap.put("india",3);
        freqMap.put("cricket",5);
        freqMap.put("claim",2);

        PriorityQueue<String> topK = new PriorityQueue<>((w1,w2) -> {
            int freqCompare = Integer.compare(freqMap.get(w2),freqMap.get(w1));

            return (freqCompare == 0) ? w1.compareTo(w2):freqCompare;
        });

        topK.addAll(freqMap.keySet());

        while (!topK.isEmpty()) {
            String word = topK.poll();

            System.out.println(word + " -> "+ freqMap.get(word));
        }
    }
}
