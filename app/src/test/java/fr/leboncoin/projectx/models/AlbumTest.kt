package fr.leboncoin.projectx.models

import org.junit.Assert
import org.junit.Test

class AlbumTest {

    companion object {
        private lateinit var albumMock: Album
    }

    @Test
    fun `test constructor with not title`() {
        albumMock = Album(11, null)
        Assert.assertNotNull(albumMock)
    }
    @Test
    fun `test constructor with title`() {
        albumMock = Album(11, "testTitle")
        Assert.assertNotNull(albumMock)
    }
}