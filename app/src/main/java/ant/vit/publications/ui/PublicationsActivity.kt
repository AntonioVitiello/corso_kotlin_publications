package ant.vit.publications.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ant.vit.publications.R
import ant.vit.publications.model.PublicationModel
import ant.vit.publications.ui.adapter.PostListAdapter
import ant.vit.publications.viewmodel.PublicationsViewModel
import kotlinx.android.synthetic.main.activity_publications.*


/**
 * Created by Vitiello Antonio
 */
class PublicationsActivity : AppCompatActivity() {
    private val mViewModel by viewModels<PublicationsViewModel>()
    private lateinit var mAdapter: PostListAdapter
    private var mPublicationId = "60ce1d1d-32b4-4a39-914e-25231105839a"

    companion object {
        private const val TAG = "PublicationActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publications)

        mViewModel.loadPublications(mPublicationId)

        mViewModel.restResponseLiveData.observe(this, ::fillData)
        mViewModel.progressLiveData.observe(this, ::showProgress)
        mViewModel.errorLiveData.observe(this, ::showError)

        initComponents()
    }

    private fun initComponents() {
        mAdapter = PostListAdapter()
        postRecyclerView.adapter = mAdapter

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun fillData(models: MutableList<PublicationModel>) {
        mAdapter.switchData(models)
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun showProgress(isVisible: Boolean) {
        progressView.isVisible = isVisible
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }

}
