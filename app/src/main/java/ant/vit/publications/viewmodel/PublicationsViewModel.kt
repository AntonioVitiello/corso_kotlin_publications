package ant.vit.publications.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ant.vit.publications.R
import ant.vit.publications.model.PublicationModel
import ant.vit.publications.model.mapRestResponse
import ant.vit.publications.network.RestRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vitiello Antonio
 */
class PublicationsViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    var restResponseLiveData = MutableLiveData<MutableList<PublicationModel>>()
    var errorLiveData: MutableLiveData<String> = MutableLiveData()
    var progressLiveData: MutableLiveData<Boolean> = MutableLiveData()

    companion object {
        private const val TAG = "LoadRestViewModel"
    }

    fun loadPublications(publicationId: String) {
        progressLiveData.postValue(true)
        compositeDisposable.add(
            RestRepository.getRestSingle(publicationId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(::mapRestResponse)
                .subscribe({ model ->
                    progressLiveData.postValue(false)
                    restResponseLiveData.value = model
                }, {
                    progressLiveData.postValue(false)
                    val message =
                        getApplication<Application>().getString(R.string.generic_network_error_message)
                    errorLiveData.value = message
                    Log.e(TAG, null, it)
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }

}