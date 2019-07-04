// prefer dependency injection to hardwiring resouces

/* 关键点: paas the resource into the constructor when creating a new instance */
/* 白话: 硬编码很难应对一对多的情况,我们需要个性化定制资源，只在新建instance的时候传入resource参数，
比如一个SpellChecker类可能会check多种语言，就需要匹配不同的语音字典 */

// Inappropriate use of static utility
public class SpellChecker {
    // 直接定义static final变量
    private static final Lexicon dictionary = ...;

    private SpellChecker() {} // Noninstantiable

    public boolean isValid(String word) { ... }
    public static List<String> suggestions(String typo) { ... }
}

// Inappropriate use of singleton - inflexible & untestable
public class SpellChecker {
    private final Lexicon dictionary = ...;

    private SpellChecker(...) {}
    public static INSTANCE = new SpellChecker(...);

    public boolean isValid(String word) { ... }
    public List<String> suggestions(String typo) { ... }
}

// Dependency injection provides flexibility and testability
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) { ... }
    public List<String> suggestions(String typo) { ... }
}

