#!/usr/bin/python

import unittest


class HashMap(object):
    def __init__(self):
        self.SIZE = 8
        self.array = [list() for _ in range(self.SIZE)]
    
    def __getitem__(self, key):
        index = self._getIndex(key)
        for v in self.array[index]:
            if v[0] == key :
                return v[1]

        return None

    def __setitem__(self, key, value):
        index = self._getIndex(key)
        self.array[index].append((key,value))
    
    def __delitem__(self, key):
        index = self._getIndex(key)
        for i, v in enumerate(self.array[index]):
            if v[0] == key :
                del self.array[index][i]
                return

    def __contains__(self, key):
        index = self._getIndex(key)
        for v in self.array[index]:
            if v[0] == key :
                return True
        return False

    def __repr__(self):
        i = 1
        r = ""
        for ar in self.array:
            r+=str(i)+":"+str(ar)
            i+=1
        return r

    def _getIndex(self, key):         
        h = hash(key)
        index = h & (len(self.array) - 1)
        return index

class HashMapUnitTest(unittest.TestCase):
    def setUp(self):
        self.hmap = HashMap()
        self.key = ("s", 4)

    def testAddingData_Ok(self):
        self.hmap[self.key] = 3
        self.assertTrue(self.hmap[self.key], 3)
    
    def testContains_Ok(self):
        self.hmap[5] = 25
        r = 5 in self.hmap
        self.assertTrue(r)

    def testDelete_Ok(self):
        for ind in range(100):        
            self.hmap[ind] = ind
        del self.hmap[10]
        for ind in range(100):
            if ind != 10:
                self.assertIn(ind, self.hmap)
        self.assertNotIn(10, self.hmap)
    
if __name__ == "__main__":
    unittest.main()
        
