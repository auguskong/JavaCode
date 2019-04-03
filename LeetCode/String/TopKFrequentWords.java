public class TopKFrequentWords{
    public List<String> topK(String[] words, int k) {
        HashMap<String, Integer> wordCounts = countWords(words);
        return topKFrequentWordsFromWordCounts(wordCounts,
            Math.min(k, wordCount.size()));
    }

    private HashMap<String, Integer> countWords(String[] words) {
        HashMap<String, Integer> wordCounts
    }
}