package fr.leboncoin.projectx.models

import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test

class TrackTest {

    companion object {
        private lateinit var trackMock: Track
        private const val albumIdTest = 1L
        private const val idTest = 1L
        private const val titleTest = "testTitle"
        private const val urlTest = "testUrl"
        private const val thumbnailUrlTest = "testThumbnailUrl"
        @BeforeClass
        @JvmStatic
        fun beforeTesting() {
            trackMock = Track(albumIdTest, idTest, titleTest, urlTest, thumbnailUrlTest)
        }
    }
    @Test
    fun `test constructor`() {
        Assert.assertNotNull(trackMock)
    }

    @Test
    fun getAlbumId() {
        Assert.assertEquals(albumIdTest, trackMock.albumId)
    }

    @Test
    fun setAlbumId() {
        trackMock.albumId = albumIdTest
        Assert.assertEquals(albumIdTest, trackMock.albumId)
    }

    @Test
    fun getId() {
        Assert.assertEquals(idTest, trackMock.id)
    }

    @Test
    fun setId() {
        trackMock.id = idTest
        Assert.assertEquals(idTest, trackMock.id)
    }

    @Test
    fun getTitle() {
        Assert.assertEquals(titleTest, trackMock.title)
    }

    @Test
    fun setTitle() {
        trackMock.title = titleTest
        Assert.assertEquals(titleTest, trackMock.title)
    }

    @Test
    fun getUrl() {
        Assert.assertEquals(urlTest, trackMock.url)
    }

    @Test
    fun setUrl() {
        trackMock.url = urlTest
        Assert.assertEquals(urlTest, trackMock.url)
    }

    @Test
    fun getThumbnailUrl() {
        Assert.assertEquals(thumbnailUrlTest, trackMock.thumbnailUrl)
    }

    @Test
    fun setThumbnailUrl() {
        trackMock.thumbnailUrl = thumbnailUrlTest
        Assert.assertEquals(thumbnailUrlTest, trackMock.thumbnailUrl)
    }

    @Test
    fun testToString() {
        Assert.assertEquals(
            "$albumIdTest,$idTest,$titleTest,$urlTest,$thumbnailUrlTest",
            trackMock.toString()
        )
    }
}