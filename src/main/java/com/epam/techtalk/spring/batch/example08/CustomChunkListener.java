package com.epam.techtalk.spring.batch.example08;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class CustomChunkListener implements ChunkListener {
    @Override
    public void beforeChunk(ChunkContext context) {
        System.out.println("Chunk is going to start");
    }

    @Override
    public void afterChunk(ChunkContext context) {
        System.out.println("Chunk is finished");
    }

    @Override
    public void afterChunkError(ChunkContext context) {

    }
}
