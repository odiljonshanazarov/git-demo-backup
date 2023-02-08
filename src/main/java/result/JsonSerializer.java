package result;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonSerializer {


    public void writeToJson(Collection<task2_1.result.Game> gameList) throws IOException, URISyntaxException {

        ObjectMapper mapper = new ObjectMapper();

//        URL resource = getClass().getResource("testdata.json");
//        new File("testdata.json");
//        File file = new File(resource.toURI());

        mapper.writeValue(new File("testdata.json"), gameList);
    }

    public List<task2_1.result.Game> readFromJson() throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();

        Path path = Path.of(getClass().getResource("/testdata.json").toURI());
        String readFile = Files.readString(path);

        return mapper.readValue(readFile, new TypeReference<List<task2_1.result.Game>>() {
        });
    }


    public void compareGames() throws URISyntaxException, IOException {

        //Game game = new Game("dummy");

        List<task2_1.result.Game> firstGames = new ArrayList<>();
        //firstGames.add(game);

        writeToJson(firstGames);

        List<task2_1.result.Game> afterGames = readFromJson();

        //assertThat(firstGames).isEqualTo(afterGames);

    }


}
