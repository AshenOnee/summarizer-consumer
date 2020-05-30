package tests;
import org.junit.Assert;
import org.junit.Test;
import tools.TextTools;

import java.io.IOException;

public class Tests {

    @Test
    public void sentencesSplitter1(){
        String testSentence = "Разные знаки окончания предложения. Разные знаки окончания предложения! Разные знаки окончания предложения?";
        String[] expectedResult = new String[]{
                "Разные знаки окончания предложения. ",
                "Разные знаки окончания предложения! ",
                "Разные знаки окончания предложения?"
        };
        String[] actualResult = TextTools.splitOnSentences(testSentence).toArray(new String[0]);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void sentencesSplitter2(){
        String testSentence = "Предложение Пушкин А.С. с инициалами. Предложение (анг. sentence) с сокращением.";
        String[] expectedResult = new String[]{
                "Предложение Пушкин А.С. с инициалами. ",
                "Предложение (анг. sentence) с сокращением."
        };
        String[] actualResult = TextTools.splitOnSentences(testSentence).toArray(new String[0]);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void sentencesSplitter3(){
        String testSentence = "Предложение 31.12.2018 – 01.01.2019 c датой.";
        String[] expectedResult = new String[]{
                "Предложение 31.12.2018 – 01.01.2019 c датой."
        };
        String[] actualResult = TextTools.splitOnSentences(testSentence).toArray(new String[0]);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void sentencesSplitter4(){
        String testSentence = "Web ссылка https://www.google.com/search.";
        String[] expectedResult = new String[]{
                "Web ссылка https://www.google.com/search."
        };
        String[] actualResult = TextTools.splitOnSentences(testSentence).toArray(new String[0]);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void textTokenizerStemmerFilter1(){
        String testSentence = "Тестовое (предложение - со) множеством; не! буквенных символов*.";
        String[] expectedResult = new String[]{
                "тестов",
                "предложен",
                "множеств",
                "буквен",
                "символ"
        };
        String[] actualResult = new String[0];
        try {
            actualResult = TextTools.textStemming(testSentence).toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void textTokenizerStemmerFilter2() {
        String testSentence = "Слова через дефис: мать-и-мачеха, юго-запад, темно-красный.";
        String[] expectedResult = new String[]{
                "слов",
                "дефис",
                "мат",
                "мачех",
                "юг",
                "запад",
                "темн",
                "красн"
        };
        String[] actualResult = new String[0];
        try { actualResult = TextTools.textStemming(testSentence).toArray(new String[0]); }
        catch (IOException e) { e.printStackTrace(); }

        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void textTokenizerStemmerFilter3() {
        String testSentence = "вагон вагона вагоне вагонов вагоном вагоны";
        String[] expectedResult = new String[]{
                "вагон",
                "вагон",
                "вагон",
                "вагон",
                "вагон",
                "вагон"
        };
        String[] actualResult = new String[0];
        try { actualResult = TextTools.textStemming(testSentence).toArray(new String[0]); }
        catch (IOException e) { e.printStackTrace(); }

        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}