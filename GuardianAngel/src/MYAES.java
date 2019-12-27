
public class MYAES {
	final static byte es[][]= {
			 {(byte)0x63 ,(byte)0x7c ,(byte)0x77 ,(byte)0x7b ,(byte)0xf2 ,(byte)0x6b ,(byte)0x6f ,(byte)0xc5,(byte)0x30  ,(byte)0x1 ,(byte)0x67 ,(byte)0x2b ,(byte)0xfe ,(byte)0xd7 ,(byte)0xab ,(byte)0x76},
			 {(byte)0xca ,(byte)0x82 ,(byte)0xc9 ,(byte)0x7d ,(byte)0xfa ,(byte)0x59 ,(byte)0x47 ,(byte)0xf0 ,(byte)0xad ,(byte)0xd4 ,(byte)0xa2 ,(byte)0xaf ,(byte)0x9c ,(byte)0xa4 ,(byte)0x72 ,(byte)0xc0},
			 {(byte)0xb7 ,(byte)0xfd ,(byte)0x93 ,(byte)0x26 ,(byte)0x36 ,(byte)0x3f ,(byte)0xf7 ,(byte)0xcc ,(byte)0x34 ,(byte)0xa5 ,(byte)0xe5 ,(byte)0xf1 ,(byte)0x71 ,(byte)0xd8 ,(byte)0x31 ,(byte)0x15},
			  {(byte)0x4 ,(byte)0xc7 ,(byte)0x23 ,(byte)0xc3 ,(byte)0x18 ,(byte)0x96  ,(byte)0x5 ,(byte)0x9a  ,(byte)0x7 ,(byte)0x12 ,(byte)0x80 ,(byte)0xe2 ,(byte)0xeb ,(byte)0x27 ,(byte)0xb2 ,(byte)0x75},
			  {(byte)0x9 ,(byte)0x83 ,(byte)0x2c ,(byte)0x1a ,(byte)0x1b ,(byte)0x6e ,(byte)0x5a ,(byte)0xa0 ,(byte)0x52 ,(byte)0x3b ,(byte)0xd6 ,(byte)0xb3 ,(byte)0x29 ,(byte)0xe3 ,(byte)0x2f ,(byte)0x84},
			 {(byte)0x53 ,(byte)0xd1  ,(byte)0x0 ,(byte)0xed ,(byte)0x20 ,(byte)0xfc ,(byte)0xb1 ,(byte)0x5b ,(byte)0x6a ,(byte)0xcb ,(byte)0xbe ,(byte)0x39 ,(byte)0x4a ,(byte)0x4c ,(byte)0x58 ,(byte)0xcf},
			 {(byte)0xd0 ,(byte)0xef ,(byte)0xaa ,(byte)0xfb ,(byte)0x43 ,(byte)0x4d ,(byte)0x33 ,(byte)0x85 ,(byte)0x45 ,(byte)0xf9  ,(byte)0x2 ,(byte)0x7f ,(byte)0x50 ,(byte)0x3c ,(byte)0x9f ,(byte)0xa8},
			 {(byte)0x51 ,(byte)0xa3 ,(byte)0x40 ,(byte)0x8f ,(byte)0x92 ,(byte)0x9d ,(byte)0x38 ,(byte)0xf5 ,(byte)0xbc ,(byte)0xb6 ,(byte)0xda ,(byte)0x21 ,(byte)0x10 ,(byte)0xff ,(byte)0xf3 ,(byte)0xd2},
			 {(byte)0xcd  ,(byte)0xc ,(byte)0x13 ,(byte)0xec ,(byte)0x5f ,(byte)0x97 ,(byte)0x44 ,(byte)0x17 ,(byte)0xc4 ,(byte)0xa7 ,(byte)0x7e ,(byte)0x3d ,(byte)0x64 ,(byte)0x5d ,(byte)0x19 ,(byte)0x73},
			 {(byte)0x60 ,(byte)0x81 ,(byte)0x4f ,(byte)0xdc ,(byte)0x22 ,(byte)0x2a ,(byte)0x90 ,(byte)0x88 ,(byte)0x46 ,(byte)0xee ,(byte)0xb8 ,(byte)0x14 ,(byte)0xde ,(byte)0x5e  ,(byte)0xb ,(byte)0xdb},
			 {(byte)0xe0 ,(byte)0x32 ,(byte)0x3a  ,(byte)0xa ,(byte)0x49  ,(byte)0x6 ,(byte)0x24 ,(byte)0x5c ,(byte)0xc2 ,(byte)0xd3 ,(byte)0xac ,(byte)0x62 ,(byte)0x91 ,(byte)0x95 ,(byte)0xe4 ,(byte)0x79},
			 {(byte)0xe7 ,(byte)0xc8 ,(byte)0x37 ,(byte)0x6d ,(byte)0x8d ,(byte)0xd5 ,(byte)0x4e ,(byte)0xa9 ,(byte)0x6c ,(byte)0x56 ,(byte)0xf4 ,(byte)0xea ,(byte)0x65 ,(byte)0x7a ,(byte)0xae  ,(byte)0x8},
			 {(byte)0xba ,(byte)0x78 ,(byte)0x25 ,(byte)0x2e ,(byte)0x1c ,(byte)0xa6 ,(byte)0xb4 ,(byte)0xc6 ,(byte)0xe8 ,(byte)0xdd ,(byte)0x74 ,(byte)0x1f ,(byte)0x4b ,(byte)0xbd ,(byte)0x8b ,(byte)0x8a},
			 {(byte)0x70 ,(byte)0x3e ,(byte)0xb5 ,(byte)0x66 ,(byte)0x48  ,(byte)0x3 ,(byte)0xf6  ,(byte)0xe ,(byte)0x61 ,(byte)0x35 ,(byte)0x57 ,(byte)0xb9 ,(byte)0x86 ,(byte)0xc1 ,(byte)0x1d ,(byte)0x9e},
			 {(byte)0xe1 ,(byte)0xf8 ,(byte)0x98 ,(byte)0x11 ,(byte)0x69 ,(byte)0xd9 ,(byte)0x8e ,(byte)0x94 ,(byte)0x9b ,(byte)0x1e ,(byte)0x87 ,(byte)0xe9 ,(byte)0xce ,(byte)0x55 ,(byte)0x28 ,(byte)0xdf},
			 {(byte)0x8c ,(byte)0xa1 ,(byte)0x89  ,(byte)0xd ,(byte)0xbf ,(byte)0xe6 ,(byte)0x42 ,(byte)0x68 ,(byte)0x41 ,(byte)0x99 ,(byte)0x2d  ,(byte)0xf ,(byte)0xb0 ,(byte)0x54 ,(byte)0xbb ,(byte)0x16}
	};
	final static byte[][] ds= {
			 {(byte)0x52  ,(byte)0x9 ,(byte)0x6a ,(byte)0xd5 ,(byte)0x30 ,(byte)0x36 ,(byte)0xa5 ,(byte)0x38 ,(byte)0xbf ,(byte)0x40 ,(byte)0xa3 ,(byte)0x9e ,(byte)0x81 ,(byte)0xf3 ,(byte)0xd7 ,(byte)0xfb},
			 {(byte)0x7c ,(byte)0xe3 ,(byte)0x39 ,(byte)0x82 ,(byte)0x9b ,(byte)0x2f ,(byte)0xff ,(byte)0x87 ,(byte)0x34 ,(byte)0x8e ,(byte)0x43 ,(byte)0x44 ,(byte)0xc4 ,(byte)0xde ,(byte)0xe9 ,(byte)0xcb},
			 {(byte)0x54 ,(byte)0x7b ,(byte)0x94 ,(byte)0x32 ,(byte)0xa6 ,(byte)0xc2 ,(byte)0x23 ,(byte)0x3d ,(byte)0xee ,(byte)0x4c ,(byte)0x95  ,(byte)0xb ,(byte)0x42 ,(byte)0xfa ,(byte)0xc3 ,(byte)0x4e},
			{(byte)0x8 ,(byte)0x2e ,(byte)0xa1 ,(byte)0x66 ,(byte)0x28 ,(byte)0xd9 ,(byte)0x24 ,(byte)0xb2 ,(byte)0x76 ,(byte)0x5b ,(byte)0xa2 ,(byte)0x49 ,(byte)0x6d ,(byte)0x8b ,(byte)0xd1 ,(byte)0x25},
			 {(byte)0x72 ,(byte)0xf8 ,(byte)0xf6 ,(byte)0x64 ,(byte)0x86 ,(byte)0x68 ,(byte)0x98 ,(byte)0x16 ,(byte)0xd4 ,(byte)0xa4 ,(byte)0x5c ,(byte)0xcc ,(byte)0x5d ,(byte)0x65 ,(byte)0xb6 ,(byte)0x92},
			 {(byte)0x6c ,(byte)0x70 ,(byte)0x48 ,(byte)0x50 ,(byte)0xfd ,(byte)0xed ,(byte)0xb9 ,(byte)0xda ,(byte)0x5e ,(byte)0x15 ,(byte)0x46 ,(byte)0x57 ,(byte)0xa7 ,(byte)0x8d ,(byte)0x9d ,(byte)0x84},
			 {(byte)0x90 ,(byte)0xd8 ,(byte)0xab  ,(byte)0x0 ,(byte)0x8c ,(byte)0xbc ,(byte)0xd3  ,(byte)0xa ,(byte)0xf7 ,(byte)0xe4 ,(byte)0x58  ,(byte)0x5 ,(byte)0xb8 ,(byte)0xb3 ,(byte)0x45  ,(byte)0x6},
			 {(byte)0xd0 ,(byte)0x2c ,(byte)0x1e ,(byte)0x8f ,(byte)0xca ,(byte)0x3f  ,(byte)0xf  ,(byte)0x2 ,(byte)0xc1 ,(byte)0xaf ,(byte)0xbd  ,(byte)0x3  ,(byte)0x1 ,(byte)0x13 ,(byte)0x8a ,(byte)0x6b},
			 {(byte)0x3a ,(byte)0x91 ,(byte)0x11 ,(byte)0x41 ,(byte)0x4f ,(byte)0x67 ,(byte)0xdc ,(byte)0xea ,(byte)0x97 ,(byte)0xf2 ,(byte)0xcf ,(byte)0xce ,(byte)0xf0 ,(byte)0xb4 ,(byte)0xe6 ,(byte)0x73},
			 {(byte)0x96 ,(byte)0xac ,(byte)0x74 ,(byte)0x22 ,(byte)0xe7 ,(byte)0xad ,(byte)0x35 ,(byte)0x85 ,(byte)0xe2 ,(byte)0xf9 ,(byte)0x37 ,(byte)0xe8 ,(byte)0x1c ,(byte)0x75 ,(byte)0xdf ,(byte)0x6e},
			 {(byte)0x47 ,(byte)0xf1 ,(byte)0x1a ,(byte)0x71 ,(byte)0x1d ,(byte)0x29 ,(byte)0xc5 ,(byte)0x89 ,(byte)0x6f ,(byte)0xb7 ,(byte)0x62  ,(byte)0xe ,(byte)0xaa ,(byte)0x18 ,(byte)0xbe ,(byte)0x1b},
			 {(byte)0xfc ,(byte)0x56 ,(byte)0x3e ,(byte)0x4b ,(byte)0xc6 ,(byte)0xd2 ,(byte)0x79 ,(byte)0x20 ,(byte)0x9a ,(byte)0xdb ,(byte)0xc0 ,(byte)0xfe ,(byte)0x78 ,(byte)0xcd ,(byte)0x5a ,(byte)0xf4},
			 {(byte)0x1f ,(byte)0xdd ,(byte)0xa8 ,(byte)0x33 ,(byte)0x88  ,(byte)0x7 ,(byte)0xc7 ,(byte)0x31 ,(byte)0xb1 ,(byte)0x12 ,(byte)0x10 ,(byte)0x59 ,(byte)0x27 ,(byte)0x80 ,(byte)0xec ,(byte)0x5f},
			 {(byte)0x60 ,(byte)0x51 ,(byte)0x7f ,(byte)0xa9 ,(byte)0x19 ,(byte)0xb5 ,(byte)0x4a  ,(byte)0xd ,(byte)0x2d ,(byte)0xe5 ,(byte)0x7a ,(byte)0x9f ,(byte)0x93 ,(byte)0xc9 ,(byte)0x9c ,(byte)0xef},
			 {(byte)0xa0 ,(byte)0xe0 ,(byte)0x3b ,(byte)0x4d ,(byte)0xae ,(byte)0x2a ,(byte)0xf5 ,(byte)0xb0 ,(byte)0xc8 ,(byte)0xeb ,(byte)0xbb ,(byte)0x3c ,(byte)0x83 ,(byte)0x53 ,(byte)0x99 ,(byte)0x61},
			 {(byte)0x17 ,(byte)0x2b  ,(byte)0x4 ,(byte)0x7e ,(byte)0xba ,(byte)0x77 ,(byte)0xd6 ,(byte)0x26 ,(byte)0xe1 ,(byte)0x69 ,(byte)0x14 ,(byte)0x63 ,(byte)0x55 ,(byte)0x21  ,(byte)0xc ,(byte)0x7d}
	};
	final static int[][] eMixS= {
			{0x02,0x03,0x01,0x01},
			{0x01,0x02,0x03,0x01},
			{0x01,0x01,0x02,0x03},
			{0x03,0x01,0x01,0x02}
	};
	final static int[][] dMixS= {
			{0x0e,0x0b,0x0d,0x09},
			{0x09,0x0e,0x0b,0x0d},
			{0x0d,0x09,0x0e,0x0b},
			{0x0b,0x0d,0x09,0x0e}
	};
	final static byte Rcon[][]=
		{
				{0x1,0,0,0},	
				{0x2,0,0,0},	
				{0x4,0,0,0},	
				{0x8,0,0,0},	
				{0x10,0,0,0},	
				{0x20,0,0,0},	
				{0x40,0,0,0},	
				{(byte)0x80,0,0,0},	
				{0x1b,0,0,0},	
				{0x36,0,0,0}
		};
	byte keys[][]=new byte[44][4];
	public static void main(String[] args) {
		MYAES aes=new MYAES();
		byte[][] data= {
				{(byte)0x01,(byte)0x89,(byte)0xfe,(byte)0x76},
				{(byte)0x23,(byte)0xab,(byte)0xdc,(byte)0x54},
				{(byte)0x45,(byte)0xcd,(byte)0xba,(byte)0x32},
				{(byte)0x67,(byte)0xef,(byte)0x98,(byte)0x10}
		};
		byte[][] key1= {
				{(byte)0x0f,(byte)0x47,(byte)0x0c,(byte)0xaf},
				{(byte)0x15,(byte)0xd9,(byte)0xb7,(byte)0x7f},
				{(byte)0x71,(byte)0xe8,(byte)0xad,(byte)0x67},
				{(byte)0xc9,(byte)0x59,(byte)0xd6,(byte)0x98}
		};
		aes.encrypt(data, key1);
		aes.print(data);
		aes.decrypt(data, key1);
		aes.print(data);
	}
	public void substituteBytes(byte[][] in, byte[][] s)
	{

		for(int j=0;j<4;j++)
			for (int i=0;i<4;i++)
			{
				if(in[i][j]>=0)
				{
					int x=in[i][j]/16;
					int y=in[i][j]%16;
					in[i][j]=s[x][y];
				}
				else
				{
					in[i][j]=(byte) ~in[i][j];
					int x=in[i][j]/16;
					int y=in[i][j]%16;
					x=15-x;
					y=15-y;
					in[i][j]=s[x][y];
				}

				
			}
	}
	public void eShiftRows(byte[][] in)
	{
		for(int i=1;i<4;i++)
		{
			int n=i;
			if(n>in[i].length/2)
			{
				n=in[i].length-n;
				for(int j=in[i].length-1;j-n>=0;j--)
				{
					byte temp=in[i][j];
					in[i][j]=in[i][j-n];
					in[i][j-n]=temp;
				}
			}
			else
			{
				for(int j=0;j+n<in[i].length;j++)
				{
					byte temp=in[i][j];
					in[i][j]=in[i][j+n];
					in[i][j+n]=temp;
				}
			}			
		}
	}
	public void dShiftRows(byte[][] in)
	{
		for(int i=1;i<4;i++)
		{
			int n=in[i].length-i;
			if(n>in[i].length/2)
			{
				n=in[i].length-n;
				for(int j=in[i].length-1;j-n>=0;j--)
				{
					byte temp=in[i][j];
					in[i][j]=in[i][j-n];
					in[i][j-n]=temp;
				}
			}
			else
			{
				for(int j=0;j+n<in[i].length;j++)
				{
					byte temp=in[i][j];
					in[i][j]=in[i][j+n];
					in[i][j+n]=temp;
				}
			}			
		}
	}
	public void mixColumns(byte[][] in,int[][] mixS)
	{
		byte out[][]=new byte[4][4];
		for(int i=0;i<mixS[0].length;i++)
			for(int j=0;j<in.length;j++)
			{
				byte sum[]=new byte[4];
				for(int k=0;k<mixS.length;k++)
				{
					int s=mixS[i][k];
					byte b=in[k][j];
					byte[] bn=new byte[8];
					bn[0]=b;
					for(int l=1;l<8;l++)
					{
						bn[l]=(byte) (bn[l-1]<<1);
						if(bn[l-1]<0)
						{
							bn[l]=(byte) (bn[l]^0x1b);
						}
					}
					for(int l=0;s!=0;l++)
					{
						if(s%2==1)
						{
							sum[k]=(byte) (sum[k]^bn[l]);
						}
						s=(s/2);
					}
				}
				out[i][j]=(byte) (sum[0]^sum[1]^sum[2]^sum[3]);
			}
		in[0]=out[0];
		in[1]=out[1];
		in[2]=out[2];
		in[3]=out[3];
	}
	public void addRoundKey(byte[][] in,byte[][] key)
	{
		for(int i=0;i<in.length;i++)
			for(int j=0;j<in[i].length;j++)
				in[i][j]=(byte) (in[i][j]^key[i][j]);
	}
	public void keyExpansion(byte[][] key)
	{
		for(int i=0;i<key.length;i++)
			for(int j=0;j<key[i].length;j++)
			{
				keys[i][j]=key[i][j];
			}
		for(int i=4;i<keys.length;i+=4)
			for(int j=0;j<keys[i].length;j++)
			{
				if(j==0)
				{
					byte gw[]= {keys[i-3][3],keys[i-2][3],keys[i-1][3],keys[i-4][3]};
//					for(byte p:gw)
//					{
//						System.out.printf("%x\t",p);
//					}
//					System.out.println();
					g(gw,i/4);
//					for(byte p:gw)
//					{
//						System.out.printf("%x\t",p);
//					}
//					System.out.println();
					keys[i][j]=(byte) (keys[i-4][j]^gw[0]);
					keys[i+1][j]=(byte) (keys[i-3][j]^gw[1]);
					keys[i+2][j]=(byte) (keys[i-2][j]^gw[2]);
					keys[i+3][j]=(byte) (keys[i-1][j]^gw[3]);
				}
				else
				{
					keys[i][j]=(byte) (keys[i][j-1]^keys[i-4][j]);
					keys[i+1][j]=(byte) (keys[i+1][j-1]^keys[i-3][j]);
					keys[i+2][j]=(byte) (keys[i+2][j-1]^keys[i-2][j]);
					keys[i+3][j]=(byte) (keys[i+3][j-1]^keys[i-1][j]);
				}
			}
	}
	public void g(byte[] w,int round)
	{
		for (int i=0;i<4;i++)
		{
			if(w[i]>=0)
			{
				int x=w[i]/16;
				int y=w[i]%16;
				w[i]=es[x][y];
			}
			else
			{
				w[i]=(byte) ~w[i];
				int x=w[i]/16;
				int y=w[i]%16;
				x=15-x;
				y=15-y;
				w[i]=es[x][y];
			}
//			System.out.printf("%x\t",w[i]);
			w[i]=(byte) (w[i]^Rcon[round-1][i]);
		}
		
	}
	public void encrypt(byte[][] in,byte[][] key)
	{
		byte keyr[][]=new byte[4][4];
		keyExpansion(key);
		addRoundKey(in,key);
		for(int i=1;i<10;i++)
		{
			substituteBytes(in,es);
			eShiftRows(in);
			mixColumns(in,eMixS);
			keyr[0]=keys[4*i];
			keyr[1]=keys[4*i+1];
			keyr[2]=keys[4*i+2];
			keyr[3]=keys[4*i+3];
			addRoundKey(in,keyr);
		}
		substituteBytes(in,es);
		eShiftRows(in);
		keyr[0]=keys[40];
		keyr[1]=keys[41];
		keyr[2]=keys[42];
		keyr[3]=keys[43];
		addRoundKey(in,keyr);
	}
	public void decrypt(byte[][] in,byte[][] key)
	{
		byte keyr[][]=new byte[4][4];
		keyExpansion(key);
		keyr[0]=keys[40];
		keyr[1]=keys[41];
		keyr[2]=keys[42];
		keyr[3]=keys[43];
		addRoundKey(in,keyr);
		for(int i=1;i<10;i++)
		{
			dShiftRows(in);
			substituteBytes(in,ds);
			keyr[0]=keys[44-4*i-4];
			keyr[1]=keys[44-4*i-3];
			keyr[2]=keys[44-4*i-2];
			keyr[3]=keys[44-4*i-1];
			addRoundKey(in,keyr);
			mixColumns(in,dMixS);
		}
		dShiftRows(in);
		substituteBytes(in,ds);
		addRoundKey(in,key);
	}
	public void print(byte[][] in)
	{
		for(int i=0;i<in.length;i++)
		{
			for(int j=0;j<in[i].length;j++)
				System.out.printf("%x\t",in[i][j]);
			System.out.println();
			if((i+1)%4==0)
				System.out.println();
		}
	}
}
