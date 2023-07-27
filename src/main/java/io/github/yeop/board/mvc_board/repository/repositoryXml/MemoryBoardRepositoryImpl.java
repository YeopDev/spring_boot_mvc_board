package io.github.yeop.board.mvc_board.repository.repositoryXml;

import io.github.yeop.board.mvc_board.domain.Board;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Component
public class MemoryBoardRepositoryImpl implements BoardRepository {
    private Map<Integer, Board> store = new HashMap<>();

    @Override
    public List<Board> findByAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void insertBoard(Board board) {
        store.put(board.id(), board);
    }

    @Override
    public void updateHitCount(int id) {
    }

    @Override
    public Board selectBoardDetail(int id) {
        return store.get(id);
    }

    @Override
    public void updateBoard(Board board) {

    }

    @Override
    public void deleteBoard(int id) {
        store.remove(id);
    }
}
