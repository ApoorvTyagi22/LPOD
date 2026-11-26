class Solution:
    def canAliceWin(self, n: int) -> bool:
        if n < 10: 
            return False

        n -= 10

        bobTurn = True
        toRemove = 9
        while n > 0: 
            if bobTurn: 
                if n >= toRemove: 
                    n -= toRemove
                    toRemove -= 1
                    bobTurn = False 
                else: 
                    return True 

            else:
                if n >= toRemove: 
                    n -= toRemove
                    toRemove -= 1
                    bobTurn = True
                else: 
                    return False

        if not bobTurn: 
            return False
        else:
            return True 
                    