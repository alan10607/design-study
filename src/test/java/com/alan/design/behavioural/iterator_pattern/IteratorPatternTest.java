package com.alan.design.behavioural.iterator_pattern;

import com.alan.design.behavioural.iterator_pattern.aggregate.HotProductCollection;
import com.alan.design.behavioural.iterator_pattern.aggregate.LatestProductCollection;
import com.alan.design.behavioural.iterator_pattern.iterator.HotProductIterator;
import com.alan.design.behavioural.iterator_pattern.iterator.LatestProductIterator;
import com.alan.design.behavioural.iterator_pattern.iterator.RecommendationIterator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IteratorPatternTest {

    @Test
    void testArrayListIterator() {
        Product hot1 = new Product(1L, "hot1");
        Product hot2 = new Product(2L, "hot2");
        HotProductCollection hotProductCollection = new HotProductCollection();
        hotProductCollection.add(hot1);
        hotProductCollection.add(hot2);
        HotProductIterator hotProductIterator = hotProductCollection.getIterator();

        assertTrue(hotProductIterator.hasNext());
        assertEquals(hotProductIterator.next(), hot1);
        assertTrue(hotProductIterator.hasNext());
        assertEquals(hotProductIterator.next(), hot2);
        assertFalse(hotProductIterator.hasNext());
    }

    @Test
    void testLinkedHashSetIterator() {
        Product latest1 = new Product(11L, "latest1");
        Product latest2 = new Product(12L, "latest2");
        LatestProductCollection latestProductCollection = new LatestProductCollection();
        latestProductCollection.add(latest1);
        latestProductCollection.add(latest2);
        LatestProductIterator latestProductIterator = latestProductCollection.getIterator();

        assertTrue(latestProductIterator.hasNext());
        assertEquals(latestProductIterator.next(), latest1);
        assertTrue(latestProductIterator.hasNext());
        assertEquals(latestProductIterator.next(), latest2);
        assertFalse(latestProductIterator.hasNext());
    }

    @Test
    void testMergedIterator() {
        Product hot1 = new Product(1L, "hot1");
        Product hot2 = new Product(2L, "hot2");
        HotProductCollection hotProductCollection = new HotProductCollection();
        hotProductCollection.add(hot1);
        hotProductCollection.add(hot2);
        HotProductIterator hotProductIterator = hotProductCollection.getIterator();


        Product latest1 = new Product(11L, "latest1");
        Product latest2 = new Product(12L, "latest2");
        LatestProductCollection latestProductCollection = new LatestProductCollection();
        latestProductCollection.add(latest1);
        latestProductCollection.add(latest2);
        LatestProductIterator latestProductIterator = latestProductCollection.getIterator();

        // iterator pattern can be merged
        RecommendationIterator recommendationIterator
                = new RecommendationIterator(Arrays.asList(hotProductIterator, latestProductIterator));

        assertTrue(recommendationIterator.hasNext());
        assertEquals(recommendationIterator.next(), hot1);
        assertTrue(recommendationIterator.hasNext());
        assertEquals(recommendationIterator.next(), hot2);
        assertTrue(recommendationIterator.hasNext());
        assertEquals(recommendationIterator.next(), latest1);
        assertTrue(recommendationIterator.hasNext());
        assertEquals(recommendationIterator.next(), latest2);
        assertFalse(recommendationIterator.hasNext());
    }

}