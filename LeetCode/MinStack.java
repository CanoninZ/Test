// public class MinStack {
//   Stack<Integer> sta = new Stack<Integer>();
//   int min = Integer.MAX_VALUE;
   //必须把min 预设为 max integer，否则 pop（）最后一个“真正的元素”时会出问题
//   public void push(int x){
//       if(sta.isEmpty()){
//           sta.push(min);
//           sta.push(x);
//           min = x;
//       }else{
//           if(x <= min){//必须是<=， 否侧pop min value时会出问题
//               sta.push(min);
//               min = x;
//               sta.push(x);
//           }else
//           sta.push(x);
//       }
       
//   }
//   public  void pop(){
       
//       int res;
//       res = sta.pop();
//       if(res == min ){
//           min = sta.pop();
//       }
//     //   return res;
//   }
//   public int top(){
//       int res;
//       res = sta.peek();
//       return res;
//   }
//   public int getMin(){
//         int res;
//         res = min;
//         return res;
//   }
   
// }


class MinStack
{
    //打包成一个类，对于每一个入栈的int 都会附加此时的min value
    static class Element
    {
        final int value;
        final int min;
        Element(final int value, final int min)
        {
            this.value = value;
            this.min = min;
        }
    }
    final Stack<Element> stack = new Stack<>();
    
    public void push(int x) {
        final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
        stack.push(new Element(x, min));
    }

    public void pop()
    {
        stack.pop();
    }

    public int top()
    {
        return stack.peek().value;
    }

    public int getMin()
    {
        return stack.peek().min;
    }
}