package com.devahir.mastery.ui.base;

import com.devahir.mastery.data.DataManager;
import com.devahir.mastery.data.network.WrapperError;
import com.devahir.mastery.utils.rx.SchedulerProvider;
import com.google.gson.JsonSyntaxException;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import static com.devahir.mastery.utils.AppConstants.API_STATUS_CODE_LOCAL_ERROR;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "BasePresenter";
    @Inject
    public DataManager mDataManager;
    @Inject
    public SchedulerProvider mSchedulerProvider;
    @Inject
    public CompositeDisposable mCompositeDisposable;

    private V mMvpView;


    public BasePresenter() {

    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void handleApiError(Throwable error) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                   // mView.onError("Unauthorised User ");
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                   // mView.onError("Forbidden");
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    //mView.onError("Internal Server Error");
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                   // mView.onError("Bad Request");
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    //mView.onError("No Internet Connection");
                    break;
                default:
                   // mView.onError(error.getLocalizedMessage());

            }
        } else if (error instanceof WrapperError) {
            //mView.onError(error.getMessage());
        } else if (error instanceof JsonSyntaxException) {
           // mView.onError("Something Went Wrong API is not responding properly!");
        } else {
            //mView.onError(error.getMessage());
        }

    }

    @Override
    public void setUserAsLoggedOut() {
        //getDataManager().setAccessToken(null);
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
