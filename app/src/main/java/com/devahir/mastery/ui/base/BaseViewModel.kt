package com.devahir.mastery.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonSyntaxException
import com.devahir.mastery.data.network.WrapperError
import com.devahir.mastery.utils.AppConstants.API_STATUS_CODE_LOCAL_ERROR
import com.devahir.mastery.utils.Screen
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import javax.net.ssl.HttpsURLConnection


/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
abstract class BaseViewModel constructor(
    var schedulerProvider: SchedulerProvider,
    var compositeDisposable: CompositeDisposable
) : ViewModel() {
    var showLoading = MutableLiveData<Boolean>()
    var nextScreen = MutableLiveData<Screen>()
    override fun onCleared() {
        compositeDisposable.dispose()

        super.onCleared()
    }

    fun handleApiError(error: Throwable) {
        if (error is HttpException) {
            when (error.code()) {
                HttpsURLConnection.HTTP_UNAUTHORIZED -> {
                }
                HttpsURLConnection.HTTP_FORBIDDEN -> {
                }
                HttpsURLConnection.HTTP_INTERNAL_ERROR -> {
                }
                HttpsURLConnection.HTTP_BAD_REQUEST -> {
                }
                API_STATUS_CODE_LOCAL_ERROR -> {
                }
            }// mView.onError("Unauthorised User ");
            // mView.onError("Forbidden");
            //mView.onError("Internal Server Error");
            // mView.onError("Bad Request");
            //mView.onError("No Internet Connection");
            // mView.onError(error.getLocalizedMessage());
        } else if (error is WrapperError) {
            //mView.onError(error.getMessage());
        } else if (error is JsonSyntaxException) {
            // mView.onError("Something Went Wrong API is not responding properly!");
        } else {
            //mView.onError(error.getMessage());
        }

    }

    fun setUserAsLoggedOut() {
        //getDataManager().setAccessToken(null);
    }

    class MvpViewNotAttachedException :
        RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")

    companion object {

        private val TAG = "BasePresenter"
    }

}
