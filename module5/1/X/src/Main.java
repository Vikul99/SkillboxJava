public class Main {
    public static void main(String[] args) {
        String[][] mark = {
                {"X     X"},
                {" X   X"},
                {"  X X"},
                {"   X"},
                {"  X X"},
                {" X   X"},
                {"X     X"},
        };

        for (int i = 0; i < mark.length; ++i) {
            for (int j = 0; j < mark[i].length; ++j) {
                System.out.println("\t" + mark[i][j]);
            }
        }
    }
}
