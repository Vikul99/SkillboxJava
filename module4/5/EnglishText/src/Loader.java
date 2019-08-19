public class Loader {
    public static void main(String[] args) {
        String text = "Advertisements want to persuade us to buy particular products How do they do it?\n" +
                "\n" +
                "Let’s imagine …You’re watching TV. It’s a hot evening: You feel thirsty. You see an advert for a refreshing drink. You see people looking cool and relaxed. You notice the name of the refreshing drink because you think it could be useful for you to satisfy your thirst.\n" +
                "\n" +
                "Advertisers study how people learn so that they can ‘teach’ them to respond to their advertising. They want us to be interested, to try something, and then to do it again. These are the elements of learning: interest, experience and repetition. If an advert can achieve this, it is successful. If an advert works well, the same technique can be used to advertise different things. So, for example, in winter if the weather is cold and you see a family having a warming cup of tea and feeling cosy, you may be interested and note the name of the tea … Here the same technique is being used as with the cool, refreshing drink.\n" +
                "\n" +
                "If advertisements are to he learned, there is a need for lots of repetition. But advertisers have to be careful because too much repetition can result in consumer tiredness and the message may fall on’deal ears’.\n" +
                "\n" +
                "Consumers learn to generalize from what they have learned. So advertisers sometimes copy a highly successful idea that has been well learned by consumers. For example, the highly successful ‘Weston Tea Country’ advertising for different tea has led to ‘DAEWOO Country’ for automobile dealers and ‘Cadbury Country’ for chocolate bars.";

        String[] words = text.split("[^A-Za-z]+");
        for (int i = 0; i < words.length; ++i) {
            System.out.println(words[i]);
        }
    }
}
