package WeeklyContest251;

public class Third {
    int max = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors){
        boolean[] visited = new boolean[mentors.length];
        dfs(visited, students, mentors, 0, 0);
        return 0;    
    }

    public void dfs(boolean[] visited, int[][] students, int[][] mentors, int index, int score){
        if(index >= students.length){
            max = Math.max(max, score);
            return;
        }

        for(int i = 0; i < mentors.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(visited, students, mentors, index + 1, score + getScore(students[index], mentors[i]));
                visited[i] = false;
            }
        }
    }

    public int getScore(int[] student, int[] mentor){
        int score = 0;

        for(int i = 0; i < student.length; i++){
            if(student[i] == mentor[i]) score++;
        }

        return score;
    }

    
}
