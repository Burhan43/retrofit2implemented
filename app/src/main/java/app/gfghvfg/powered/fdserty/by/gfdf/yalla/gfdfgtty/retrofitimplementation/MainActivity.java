package app.gfghvfg.powered.fdserty.by.gfdf.yalla.gfdfgtty.retrofitimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mLog;
    private Button clear;
    private TextView run;
    private MyWebInterface myWebInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        initCalls(clear, run);
        myWebInterface = MyWebInterface.retrofit.create(MyWebInterface.class);
    }

    private void initCalls(Button clear, TextView run) {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearOutput();
            }
        });
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runCode();
            }
        });
    }

    private void initViews() {
        mLog = findViewById(R.id.log);
        clear = findViewById(R.id.button2);
        run = findViewById(R.id.button);


    }

    public void runCode() {
//        getPosts();
//        getComments();
//        getCommentsQueried();
//        getCommentsQueriedWithOrderAndSortMultpleParameters();

//        createPost();
//        createPostUserInputs();


//        replacePost();
//        updatePost();

        deletePost();
    }

    private void deletePost() {

        Post post = new Post(14, "title 14", null);
//        Post post=new Post(14,"title 14","body 14");


        Call<Void> call = myWebInterface.deletePost(5);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;

                    mLog.setText(String.valueOf(response.code()));

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }


    private void updatePost() {

        Post post = new Post(14, "title 14", null);
//        Post post=new Post(14,"title 14","body 14");


        Call<Post> postCall = myWebInterface.patchPost(5, post);


        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;

                    mLog.setText(String.valueOf(response.code()));
                    showPosts(response.body());

                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }


    private void replacePost() {

        Post post = new Post(14, "title 14", null);
//        Post post=new Post(14,"title 14","body 14");


        Call<Post> postCall = myWebInterface.putPost(5, post);


        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;

                    mLog.setText(String.valueOf(response.code()));
                    showPosts(response.body());

                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }

    private void createPostUserInputs() {

//        Call<Post> postCall= myWebInterface.createPost(4,"title 4","body 4");


//        call using map


        Map<String, String> map = new HashMap<>();


        map.put("userId", "13");
        map.put("title", "title 13");
        map.put("body", "body 13");
        Call<Post> postCall = myWebInterface.createPost(map);

        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;

                    mLog.setText(String.valueOf(response.code()));
                    showPosts(response.body());

                } else {
//                    mLog.setText(response.message());
                }


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }

    private void createPost() {
        Post post = new Post(1, "title1", "body 1");

        Call<Post> postCall = myWebInterface.createPost(post);

        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;

                    mLog.setText(String.valueOf(response.code()));
                    showPosts(response.body());

                } else {
//                    mLog.setText(response.message());
                }


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }

    private void getCommentsQueriedWithOrderAndSortMultpleParameters() {
//        use values by taking from user or as required in getComments i pass 3, "id","desc" for testing
//        Call<List<Comment>> call=myWebInterface.getCommentsQueriedMultipleParameterized(3,"id","desc");


        //        below is example how you can skip parameters by just passing null

//        Call<List<Comment>> call=myWebInterface.getCommentsQueriedMultipleParameterized(3,"id",null);
//        Call<List<Comment>> call=myWebInterface.getCommentsQueriedMultipleParameterized(3,null,null);


//        if you want to skip all you can see implementation in interface class

//        Call<List<Comment>> call=myWebInterface.getCommentsQueriedMultipleParameterized(null,null,null);


        // for different values for same arg two ways

//        using var args...
        //  using var array for arguments 1st

//        Call<List<Comment>> call=myWebInterface.getCommentsQueriedMultipleParameterized(null,null,1,2,3);


//        using Array
        //  using var array for arguments 2nd

//        Call<List<Comment>> call=myWebInterface.getCommentsQueriedMultipleParameterized(new Integer[]{1,2,3,4},null,null);


        // pass using Map


        Map<String, String> params = new HashMap<>();

        params.put("postId", "3");
        params.put("_sort", "id");
        params.put("_order", "desc");

//        we can change queries here as required


//        params.put("postId","3");
//        params.put("_sort","email");
//        params.put("_order","asc");


//        Call<List<Comment>> call=myWebInterface.getCommentsQueriedMultipleParameterized(params);


//        passing url directly with no queries or conditions

        Call<List<Comment>> call = myWebInterface.getCommentsQueriedMultipleParameterized("https://jsonplaceholder.typicode.com/comments?postId=13");


        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;

                    showComments(response.body());

                } else {
                    mLog.setText(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getCommentsQueried() {
//        use post by taking from user or as required in getComments i pass 5 for testing
        Call<List<Comment>> call = myWebInterface.getCommentsQueried(5);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;

                    showComments(response.body());

                } else {
                    mLog.setText(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getComments() {
//        use post by taking from user or as required in getComments i pass 5 for testing
        Call<List<Comment>> call = myWebInterface.getComments(5);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;

                    showComments(response.body());

                } else {
                    mLog.setText(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void showComments(List<Comment> body) {
        for (Comment comment : body) {
            mLog.append("id: " + comment.getId() + "\n");
            mLog.append("postId: " + comment.getPostId() + "\n");
            mLog.append("user: " + comment.getName() + "\n");
            mLog.append("email: " + comment.getEmail() + "\n");
            mLog.append("body: " + comment.getBody() + "\n\n");
        }
    }

    private void getPosts() {
        Call<List<Post>> call = myWebInterface.getPosts();


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;
                    for (Post post : response.body()) {
                        showPosts(post);
                    }
                } else {
                    mLog.setText(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    private void showPosts(Post post) {
        mLog.append("\nuserId: " + post.getUserId() + "\n");
        mLog.append("id: " + post.getId() + "\n");
        mLog.append("title: " + post.getTitle() + "\n");
        mLog.append("body: " + post.getText() + "\n\n");

    }

    public void clearOutput() {

        mLog.setText("");
    }
}