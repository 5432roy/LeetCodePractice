class Solution:
    def haveConflict(self, event1: list[str], event2: list[str]) -> bool:
        if event1[0] == event2[0]: return True
    
        if event1[0] < event2[0]:
            return event1[1] >= event2[0]
        else:
            return event2[1] >= event1[0]