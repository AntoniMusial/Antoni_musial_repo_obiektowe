import java.util.HashMap;
import java.util.Scanner;

public class ChooseCategory extends Questions {
    private String selectedCategory = "";
    
    public String getSelectedCategory() { return selectedCategory; }
    public String setSelectedCategory(String selectedCategory) { return this.selectedCategory = selectedCategory; }

    public void choose() {
        Questions questions = new Questions();
        HashMap<String, Object[]> objects = questions.viewQuestions();
        System.out.println("Categories");
        for (String category : objects.keySet()) {
            System.out.println("\t" + category);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a category | ");
        selectedCategory = scanner.nextLine();

        while (!objects.containsKey(selectedCategory)) {
            System.out.println("Category not found | " + selectedCategory);
            System.out.print("Please choose another category | ");
            selectedCategory = scanner.nextLine();
        }

        setSelectedCategory(selectedCategory);
    }

    public static void main(String[] args) {
        ChooseCategory chooseCategory = new ChooseCategory();
        chooseCategory.choose();

        ViewQuestionsFromSelectedCategory viewQuestions = new ViewQuestionsFromSelectedCategory();
        viewQuestions.view(chooseCategory.selectedCategory);

        ViewSelectedCategory viewSelectedCategory = new ViewSelectedCategory();
        viewSelectedCategory.view(chooseCategory.selectedCategory);
        System.out.println("Selected category | " + chooseCategory.selectedCategory);
    }
}
