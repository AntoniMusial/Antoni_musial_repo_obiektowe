import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    private static Integer difficulty;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Help help = new Help();
        Settings settings = new Settings();
        Questions questions = new Questions();
        ChooseCategory chooseCategory = new ChooseCategory();
        ViewQuestionsFromSelectedCategory viewQuestionsFromSelectedCategory = new ViewQuestionsFromSelectedCategory();
        ViewSelectedCategory viewSelectedCategory = new ViewSelectedCategory();
        Draw draw = new Draw();
        ChooseDifficultyOfQuestions chooseDifficultyOfQuestions = new ChooseDifficultyOfQuestions(settings);
        
        int Choose;
        do {
            System.out.print("1 - Play\n2 - Settings\n3 - Help\n4 - Exit\n----------------------\nSelect number | ");
            Choose = sc.nextInt();

            if (Choose == 1) { // Play
                settings.cls();
                System.out.println("You have selected | Play\n----------------------");

                questions.displayQuestions();
                
            } else if (Choose == 2) { // Settings
                settings.cls();
                System.out.println("You have selected | Settings\n----------------------");

                do {
                    System.out.print("1 - Players\n2 - Rounds\n3 - Questions\n4 - Back\n----------------------\nSelect number | ");
                    Choose = sc.nextInt();

                    if (Choose == 1) {
                        settings.cls();
                        System.out.println("You have selected | Players\n----------------------");
                        
                        do {
                            System.out.print("1 - Set players\n2 - View players\n3 - Back\n----------------------\nSelect number | ");
                            Choose = sc.nextInt();
        
                            if (Choose == 1) {
                                settings.cls();
                                System.out.println("You have selected | Set players\n----------------------");

                                settings.setPlayers();

                            } else if (Choose == 2) {
                                settings.cls();
                                System.out.println("You have selected | View players\n----------------------");

                                settings.viewPlayers();

                            } else {
                                settings.cls();
                                System.out.println("Wrong number\n----------------------");

                            }
                        }
                        while (Choose != 3);
                        Choose = 0;
                        
                    } else if (Choose == 2) {
                        settings.cls();
                        System.out.println("You have selected | Rounds\n----------------------");

                        do {
                            System.out.print("1 - Set number of rounds\n2 - View number of rounds\n3 - Back\n----------------------\nSelect number | ");
                            Choose = sc.nextInt();
        
                            if (Choose == 1) {
                                settings.cls();
                                System.out.println("You have selected | Set number of rounds");

                                settings.setRounds();

                            } else if (Choose == 2) {
                                settings.cls();
                                System.out.println("You have selected | View number of rounds");

                                settings.vievRounds();

                            } else {
                                settings.cls();
                                System.out.println("Wrong number\n----------------------");

                            }
                        }
                        while (Choose != 3);
                        Choose = 0;

                    } else if (Choose == 3) {
                        settings.cls();
                        System.out.println("You have selected | Questions\n----------------------");

                        do {
                            System.out.print("1 - Categories\n2 - Difficulty of questions\n3 - Display questions\n4 - Back\n----------------------\nSelect number | ");
                            Choose = sc.nextInt();

                            if (Choose == 1) {
                                settings.cls();
                                System.out.println("You have selected | Categories\n----------------------");

                                do {
                                    System.out.print("1 - Set categories\n2 - View all categories\n3 - View selected category\n4 - Back\n----------------------\nSelect number | ");
                                    Choose = sc.nextInt();

                                    if (Choose == 1) {
                                        settings.cls();
                                        System.out.println("You have selected | Set categories");
        
                                        do {
                                            System.out.print("1 - Random\n2 - Set Category\n3 - Back\n----------------------\nSelect number | ");
                                            Choose = sc.nextInt();
                        
                                            if (Choose == 1) {
                                                settings.cls();
                                                System.out.println("You have selected | Random");

                                                Boolean rngCategory = true;
                                                System.out.println("Now the questions in game will come from random categories.");
                
                                            } else if (Choose == 2) {
                                                settings.cls();
                                                System.out.println("You have selected | Set Category");

                                                Boolean rngCategory = false;
                                                chooseCategory.choose();
                
                                            } else {
                                                settings.cls();
                                                System.out.println("Wrong number\n----------------------");
                
                                            }
                                        }
                                        while (Choose != 3);
                                        Choose = 0;
        
                                    } else if (Choose == 2) {
                                        settings.cls();
                                        System.out.println("You have selected | View all categories");

                                        ArrayList<String> categoryNames = questions.getCategoryNames();
                                        for (String categoryName : categoryNames) {
                                            System.out.print("\n\t" + categoryName);
                                        }
                                        System.out.println("\n----------------------");
        
                                    } else if (Choose == 3) {
                                        settings.cls();
                                        System.out.println("You have selected | View selected category\n----------------------");
        
                                        viewSelectedCategory.view(chooseCategory.selectedCategory);
                                        System.out.println("Selected category: " + chooseCategory.selectedCategory);
        
                                    } else {
                                        settings.cls();
                                        System.out.println("Wrong number\n----------------------");
        
                                    }
                                }
                                while (Choose != 4);
                                Choose = 0;

                            } else if (Choose == 2) {
                                settings.cls();
                                System.out.println("You have selected | Difficulty of questions");

                                do {
                                    System.out.print("1 - Set difficulty of questions\n2 - Set random difficulty of questions\n3 - Set increases difficulty (Only if you set number of rounds to minimum 3) [Recommended]\n4 - Back\n----------------------\nSelect number | ");
                                    Choose = sc.nextInt();

                                    if (Choose == 1) {
                                        settings.cls();
                                        System.out.println("You have selected | Set difficulty of questions");

                                        chooseDifficultyOfQuestions.chooseDifficulty();
                                        difficulty = chooseDifficultyOfQuestions.getDifficultyOfQuestions();

                                    } else if (Choose == 2) {
                                        settings.cls();
                                        System.out.println("You have selected | Set random difficulty of questions");

                                        chooseDifficultyOfQuestions.randomizeDifficulty();

                                    } else if (Choose == 3) {
                                        settings.cls();
                                        System.out.println("You have selected | Set increases difficulty");

                                        Integer NumberOfRounds = settings.getNumberOfRounds();
                                        if (NumberOfRounds >= 3) {
                                            chooseDifficultyOfQuestions.setIncreasedDifficulty();

                                        } else {
                                            System.out.println("Set number of rounds to 3 or bigger\nYour current number of rounds | " + NumberOfRounds);

                                        }


                                    } else {
                                        settings.cls();
                                        System.out.println("Wrong number\n----------------------");

                                    }
                                }
                                while (Choose != 4);
                                Choose = 0;

                            } else if (Choose == 3) {
                                settings.cls();
                                System.out.println("You have selected | Display questions");

                                if (difficulty != null) {
                                    chooseDifficultyOfQuestions.displayQuestions(difficulty.toString());

                                } else {
                                    chooseDifficultyOfQuestions.displayQuestions();
                                }

                            } else {
                                settings.cls();
                                System.out.println("Wrong number\n----------------------");

                            }
                        }
                        while (Choose != 4);
                        Choose = 0;
                    }
                }
                while (Choose != 4);
                Choose = 0;

            } else if (Choose == 3) { // Help
                help.instruction();

            } else if (Choose == 4) { // Exit
                settings.cls();
                System.out.println("You have selected | Exit\n\nShutting down...");

            } else {
                settings.cls();
                System.out.println("Wrong number\n----------------------");

            }
        }
        while (Choose != 4);
        Choose = 0;
    }
}
