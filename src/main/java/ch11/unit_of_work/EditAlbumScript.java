package ch11.unit_of_work;

import ch11.unit_of_work.mock.MockMapper;
import ch11.unit_of_work.mock.MockMapperRegistry;

public class EditAlbumScript {
    public static void updateTitle(Long albumId, String title) {
        UnitOfWork.newCurrent();
        MockMapper mapper = MockMapperRegistry.getMapper(Album.class);
        Album album = (Album) mapper.find(albumId);
        album.setTitle(title);
        UnitOfWork.getCurrent().commit();
    }
}
