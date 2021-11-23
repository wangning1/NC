public class MergeSortList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public ListNode Merge2(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if(list1 != null){
            p.next = list1;
        }

        if(list2 != null){
            p.next = list2;
        }

        return dummy.next;
    }
}
