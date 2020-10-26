package app.gfghvfg.powered.fdserty.by.gfdf.yalla.gfdfgtty.retrofitimplementation;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface MyWebInterface {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    String FEED = "posts";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    // for simple url
    @GET(FEED)
    Call<List<Post>> getPosts();
    // for dynamic url


    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

//    we can use multi paths too on user demand depends upon our api e.g.
//    currently in our api is not supported


//    @GET("posts/{id}/comments/{count}")
//    Call<List<Comment>> getComments(
//            @Path("id") int postId,
//            @Path("count") int count
//    );


    // Queried Parameter Handling
    @GET("comments")
    Call<List<Comment>> getCommentsQueried(@Query("postId") int postId);


    // Multiple Queried Parameters Handling

    @GET("comments")
    Call<List<Comment>> getCommentsQueriedMultipleParameterized(
            @Query("postId") int postId,
            @Query("_sort") String sortBy,
            @Query("_order") String orderBy

    );
    // Multiple Queried Parameters Handling using Map

    @GET("comments")
    Call<List<Comment>> getCommentsQueriedMultipleParameterized(@QueryMap Map<String, String> params);


//    to allow user to skip all parameters change int to Integer here we can't skip int cause it is primitive  to do so use wrapper class


    @GET("comments")
    Call<List<Comment>> getCommentsQueriedMultipleParameterized(
            @Query("postId") Integer postId,
            @Query("_sort") String sortBy,
            @Query("_order") String orderBy

    );

    //    or we can get by direct url also but for pojo is must required and necessary stuff
    @GET()
    Call<List<Comment>> getCommentsQueriedMultipleParameterized(@Url String url);

//    we can also use multple ids for that we two ways

//    1st is to use args ... and to use this it will be last parameter but it is not good if you want multiple values for different arguement


    @GET("comments")
    Call<List<Comment>> getCommentsQueriedMultipleParameterized(
            @Query("_sort") String sortBy,
            @Query("_order") String orderBy,
            @Query("postId") int... postIds

    );

    //second
    @GET("comments")
    Call<List<Comment>> getCommentsQueriedMultipleParameterized(
            @Query("postId") Integer[] ids,
            @Query("_sort") String sortBy,
            @Query("_order") String orderBy

    );


//    ways to use post in retrofit


    //    1st way
    @POST("posts")
    Call<Post> createPost(@Body Post post);


    //    2nd way pass values from user and field names must be same as in json or databases
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost
    (
            @Field("userId") int uid,
            @Field("title") String title,
            @Field("body") String bodyText
    );


    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost
            (
                    @FieldMap Map<String, String> postMap
            );


    // replace whole data with passed value

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);


    // to update data patch is used

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);


    // to Delete data DELETE is used

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}


